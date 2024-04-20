package poo.food.pineapple;

import poo.canvas_utils_square.CanvasUtilsSquares;
import poo.config.Config;
import poo.food.Food;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

//Classe para comida Pineapple - Abacaxi
public class Pineapple extends Food {

    private Canvas pineapple;

    public Pineapple() {
        creatingFood();
        setRandomPosition();
    }

    protected void creatingFood() {
        this.pineapple = CanvasUtilsSquares.buildingSquare(Color.YELLOW);
    }

    public void setRandomPosition() {
        // Setando um valor aleatório para a posição X e Y de apple
        // Setando para aparecer em um quarto a mais da tela
        this.pineapple
                .setTranslateX(randomNumbers(Config.oneQuarterWidthDown, Config.oneQuarterWidthUp - Config.squareSize));
        this.pineapple.setTranslateY(
                randomNumbers(Config.oneQuarterfHeightUp, Config.oneQuarterfHeightDown - Config.squareSize));
    }

    public Canvas getPineapple() {
        return pineapple;
    }

    // Método usado para pegar a coordenada X de pineapple
    public Integer getPosicionX() {
        return (int) this.pineapple.getTranslateX(); // Pega a posição X e faz o Casting de double para int
    }

    // Método usado para pegar a coordenada Y de pineapple
    public Integer getPosicionY() {
        return (int) this.pineapple.getTranslateY();
    }

}
