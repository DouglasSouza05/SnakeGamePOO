package poo;

import poo.food.apple.Apple;
import poo.food.pineapple.Pineapple;
import poo.scenario.Scenario;
import poo.snake.Snake;
import javafx.application.Application;
import javafx.stage.Stage;

//Classe main "Game" extendendo Classe Application para criação do Snake Game
public class Game extends Application {

    public static void main(String[] args) {
        // launch(args); //Comando para executarmos a Application
        Application.launch(Game.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Snake snake = new Snake();
        Apple apple = new Apple();
        Pineapple pineapple = new Pineapple();

        // head sendo desenhada como um square
        new Scenario(stage, snake, apple, pineapple);
    }

}
