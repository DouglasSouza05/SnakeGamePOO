package poo.scenario;

import poo.Arquivo;
import poo.play_button.PlayButton;
import poo.snake.Snake;
import poo.config.Config;
import poo.food.apple.Apple;
import poo.food.pineapple.Pineapple;
import poo.key_event_loop.KeyEventLoop;
import poo.try_again_button.TryAgainButton;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Scenario {

    private Scene scene; // Cena do JavaFX
    public Group container = new Group(); // Contem todos os elementos que estarão em scene
    private Snake snake;
    private Apple apple;
    private Pineapple pineapple;
    // private Arquivo file = new Arquivo();

    public Scenario(Stage primaryStage, Snake snake, Apple apple, Pineapple pineapple) {
        // Criando o scene
        this.scene = new Scene(container, Config.width, Config.height); // Group - Largura - Altura
        primaryStage.setScene(scene); // setando scene na Classe Scene
        primaryStage.setTitle("Snake Game - Projeto POO & BD by Douglas B.");
        primaryStage.show(); // Mostrando tela

        this.snake = snake;
        this.apple = apple;
        this.pineapple = pineapple;

        // KeyEventLoop keyEventLoop = new KeyEventLoop(this, snake, apple, pineapple);
        new KeyEventLoop(this, snake, apple, pineapple);

        // Botão play sendo necessário apertar antes para começar o jogo
        // Assim que pressiondo, adiconaca snake e as comidas a scene
        PlayButton playButton = new PlayButton(e -> {
            cleanScene();

            // Colocando o Canvas de head numa lista Children dentro de container
            container.getChildren().add(snake.getHead());

            // Colocando o Canvas de apple e pineapple dentro do container
            container.getChildren().add(apple.getApple());
            container.getChildren().add(pineapple.getPineapple());
        });

        // Adiciona o playButton a scene
        this.container.getChildren().add(playButton);

    }

    // Método que retorna uma ação quando certa tecla for pressionada
    public void keyPressed(EventHandler<? super KeyEvent> keyAction) {
        this.scene.setOnKeyPressed(keyAction);
    }

    // Método que chama a Classe TryAgainButton
    public void showGameOver(KeyEventLoop keyEventLoop) {
        TryAgainButton tryAgainButton = new TryAgainButton(e -> {
            Integer scoreTotal = Config.score;
            // file.writeScores(scoreTotal, Config.tries);
            Arquivo.writeScores(scoreTotal, Config.tries);// Escrevendo o Score anterior no ArquivoPontos.txr
            Config.tries += 1; // Aumenta o numero de tentativas
            Config.score = 0; // Igualando o score para 0 para as outras tentativas
            cleanScene();
            snake.changeSnakeColor(Color.GREEN);

            this.container.getChildren().add(this.snake.resetGame()); // Readicionando instância de head

            // Readicionando instâncias de apple e pineapple
            this.container.getChildren().add(apple.getApple());
            this.container.getChildren().add(pineapple.getPineapple());
            keyEventLoop.startLoop();
        });

        this.container.getChildren().add(tryAgainButton); // Adiciona o tryAgainButton a scene
    }

    // Limpa os elementos da tela quando acontece o Game Over
    public void cleanScene() {
        // limpando toda a lista Children de container
        this.container.getChildren().remove(0, this.container.getChildren().size());
    }

    // Classe Node é o pai de todos os elementos do JavaFX, sendo assim, o resto
    // Extends de Node
    public void addSnakeBodyPart(Node node) {
        this.container.getChildren().add(node); // Adiciona o parâmetro recebido ao container
    }

}
