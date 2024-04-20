package poo.key_event_loop;

import poo.scenario.Scenario;
import poo.snake.Snake;
import poo.config.Config;
import poo.food.apple.Apple;
import poo.food.pineapple.Pineapple;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

//Classe que verifica a movimentação da Snake em um Loop
public class KeyEventLoop {

    private Scenario scenario;
    private KeyCode currentDirection; // Atual direção que a Snake está
    private Snake snake;
    private Timeline timeline;
    private KeyFrame keyFrame;
    private Apple apple;
    private Pineapple pineapple;

    // Necessário usar a coordenada da Snake no método StartLoop
    public KeyEventLoop(Scenario scenario, Snake snake, Apple apple, Pineapple pineapple) {
        this.scenario = scenario;
        this.snake = snake;
        this.apple = apple;
        this.pineapple = pineapple;

        // Usando sintaxe Lâmbida. Ao acontecer tal evento "e", realizar ações
        // específicas
        this.scenario.keyPressed(e -> {

            KeyCode key = e.getCode(); // verifica qual tecla foi pressionada

            // !(currentDirection.equals(KeyCode.LEFT)) impede que a Snake vá na direção
            // contrária a que estava indo. Evita Bugs

            // Direita
            if (key.equals(KeyCode.RIGHT) && !KeyCode.LEFT.equals(currentDirection)) {
                currentDirection = key;
            }

            // Esquerda
            if (key.equals(KeyCode.LEFT) && !KeyCode.RIGHT.equals(currentDirection)) {
                currentDirection = key;
            }

            // Cima
            if (key.equals(KeyCode.UP) && !KeyCode.DOWN.equals(currentDirection)) {
                currentDirection = key;
            }

            // Baixo
            if (key.equals(KeyCode.DOWN) && !KeyCode.UP.equals(currentDirection)) {
                currentDirection = key;
            }

        });

        startLoop(); // chamando o Loop
    }

    public void startLoop() {
        timeline = new Timeline(); // Instância do Timeline

        // Auxiliar para o timeline
        keyFrame = new KeyFrame(Duration.millis(160), e -> {
            Integer posicionX = snake.getPosicionX();
            Integer posicionY = snake.getPosicionY();

            // Caso seja igual andar para a Direita
            if (KeyCode.RIGHT.equals(currentDirection)) {
                posicionX += Config.squareSize; // Anda para a direita uma posição equivalente ao Square
            }

            if (KeyCode.LEFT.equals(currentDirection)) {
                posicionX -= Config.squareSize;
            }

            // No caso do eixo Y, para subir se subtrai
            if (KeyCode.UP.equals(currentDirection)) {
                posicionY -= Config.squareSize;
            }

            // Para descer, soma
            if (KeyCode.DOWN.equals(currentDirection)) {
                posicionY += Config.squareSize;
            }

            // Verifica se a Snake não ultrapassou alguma borda da tela (scene)
            // -Config.squareSize é usado pois quando posicionX = Config.width uma parte já
            // está fora da tela
            // Tambem faz a verificação se não houve colisão entre Head e algum elemento de
            // Body
            if (posicionX < 0 || posicionX > Config.width - Config.squareSize
                    || posicionY < 0 || posicionY > Config.height - Config.squareSize
                    || snake.bodyCollision(posicionX, posicionY)) {
                gameOver();
            } else {
                // Verifica se a posição da Head de Snake está na mesma posição de Food (Apple
                // ou Pineapple)
                if (posicionX.equals(apple.getPosicionX()) && posicionY.equals(apple.getPosicionY())) {
                    this.apple.setRandomPosition(); // Seta uma nova posição aleatória para Food
                    this.snake.eatApple(scenario);
                } else if (posicionX.equals(pineapple.getPosicionX())
                        && posicionY.equals(pineapple.getPosicionY())) {
                    this.pineapple.setRandomPosition();
                    this.snake.eatPineapple(scenario);
                }

                this.snake.setPosition(posicionX, posicionY); // Setando as posições
            }
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Integer.MAX_VALUE); // Executa o Timeline um "número" infinito de vezes
        timeline.play(); // Executa o timeline
    }

    // O método para o keyEventLoop e ativa a Classe TryAgainButton
    public void gameOver() {
        timeline.stop();
        this.currentDirection = null; // Faz o personagem Snake voltar a ficar parado
        this.snake.deadSnake();

        // Usando "this" pois passa como parâmetro o próprio keyEventLoop
        this.scenario.showGameOver(this);
    }

}
