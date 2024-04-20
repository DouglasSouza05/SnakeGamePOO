package poo.food.apple;

import poo.canvas_utils_square.CanvasUtilsSquares;
import poo.config.Config;
import poo.food.Food;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

//Classe para comida Apple - Maça
public class Apple extends Food {

    private Canvas apple;

    public Apple() {
        creatingFood();
        setRandomPosition();
    }

    protected void creatingFood() {
        this.apple = CanvasUtilsSquares.buildingSquare(Color.RED);
    }

    public void setRandomPosition() {
        // Setando um valor aleatório para a posição X e Y de apple
        // Método randomNumbers sendo usado a partir de herança (Apple Classe filha de
        // Food)
        this.apple.setTranslateX(randomNumbers(0, Config.width - Config.squareSize));
        this.apple.setTranslateY(randomNumbers(0, Config.height - Config.squareSize));
    }

    public Canvas getApple() {
        return apple;
    }

    // Método usado para pegar a coordenada X de apple
    public Integer getPosicionX() {
        return (int) this.apple.getTranslateX(); // Pega a posição X e faz o Casting de double para int
    }

    // Método usado para pegar a coordenada Y de apple
    public Integer getPosicionY() {
        return (int) this.apple.getTranslateY();
    }

}
