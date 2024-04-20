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

//Classe que verifica a movimentação do personagem em um Loop
public class KeyEventLoop {

    private Scenario scenario;
    private KeyCode currentDirection; // Atual direção que o personagem deve estar
    private Snake snake;
    private Timeline timeline; // timeline usado para executar ações em certo
    private KeyFrame keyFrame;
    private Apple apple;
    private Pineapple pineapple;

    // Necessario usar a coordenada do personagem no método startLoop
    public KeyEventLoop(Scenario scenario, Snake snake, Apple apple, Pineapple pineapple) {
        this.scenario = scenario;
        this.snake = snake;
        this.apple = apple;
        this.pineapple = pineapple;

        // Usando sintaxe lâmbida para que ao acontecer tal evento "e", realizar certas
        // ações
        this.scenario.keyPressed(e -> {

            KeyCode key = e.getCode(); // verifica qual tecla foi pressionada

            // !(currentDirection.equals(KeyCode.LEFT)) impede que a cobra vá na direção
            // contrária
            // a que estava indo
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
        timeline = new Timeline(); // Instância do timeline

        // Auxiliar para o timeline
        keyFrame = new KeyFrame(Duration.millis(160), e -> {
            Integer posicionX = snake.getPosicionX();
            Integer posicionY = snake.getPosicionY();

            // Caso seja igual andar para a Direita
            if (KeyCode.RIGHT.equals(currentDirection)) {
                posicionX += Config.squareSize; // Anda para a direita uma posição equivalente ao square
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

            // Verifica se a snake não ultrapassou alguma borda da tela (scene)
            // -Config.squareSize é usado pois quando posicionX = Config.width uma parte ja
            // está fora da tela
            // Tambem faz a verificação se não houve colisão entre head e algum elemento de
            // body
            if (posicionX < 0 || posicionX > Config.width - Config.squareSize
                    || posicionY < 0 || posicionY > Config.height - Config.squareSize
                    || snake.bodyCollision(posicionX, posicionY)) {
                gameOver();
            } else {
                // Verifica se a posição da head de snake está na mesma posição de food (apple
                // ou pineapple)
                if (posicionX.equals(apple.getPosicionX()) && posicionY.equals(apple.getPosicionY())) {
                    this.apple.setRandomPosition(); // Seta uma nova posição aleatória para food
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
        timeline.setCycleCount(Integer.MAX_VALUE); // Executa o timeline um "numero" infinito de vezes
        timeline.play(); // Executa o timeline
    }

    // O método para o keyEventLoop e ativa a Classe TryAgainButton
    public void gameOver() {
        timeline.stop();
        this.currentDirection = null; // Faz o personagem snake voltar a ficar parado
        this.snake.deadSnake();

        // Usando "this" pois passa como parametro o próprio keyEventLoop
        this.scenario.showGameOver(this);
    }

}
