package poo.canvas_utils_square;

import poo.config.Config;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

//Classe Canvas usada p/ Criação de "desenhos" do jogo
public class CanvasUtilsSquares {

    // Construindo um quadrado com certa cor
    public static Canvas buildingSquare(Paint color) {
        Canvas square = new Canvas(Config.squareSize, Config.squareSize); // Criando um quadrado
        GraphicsContext gc = square.getGraphicsContext2D(); // Usado para adicionar elementos ao objeto

        // Primeira seta-se a cor, depois escreve-o no Canvas
        gc.setFill(color); // Setando a color do square

        // Escrevendo um objeto square no Canvas
        gc.fillRect(0, 0, Config.squareSize, Config.squareSize); // Posição x - Posição y - tamanho

        return square;
    }

}
