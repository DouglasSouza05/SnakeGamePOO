package poo.try_again_button;

import poo.config.Config;
import poo.scenario.Scenario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

//Clase que gerencia o Game Over e o Restart - VBox coloca um elemento abaixa do outro
public class TryAgainButton extends VBox {

    Scenario scenario;

    public TryAgainButton(EventHandler<ActionEvent> buttonAction) {

        Label scoreText = new Label("SCORE: " + Config.score);
        scoreText.setFont(Font.font(50));
        scoreText.setTextFill(Color.BLUE);

        Label gameOver = new Label("GAME OVER");
        gameOver.setFont(Font.font(100)); // Comando que seta o tamanho do label
        gameOver.setTextFill(Color.BLACK); // Setando a cor do label

        Button tryAgainButton = new Button("Try Again");
        tryAgainButton.setFont(Font.font(40));
        tryAgainButton.setOnAction(buttonAction); // Ação do Botão de Try Again ao clicar

        // Setando o tamanho do VBox igual ao tamanha da scene. Auxilia na hora de
        // centralizar o label
        this.setMinWidth(Config.width);
        this.setMinHeight(Config.height);

        // Por extender VBox, o comando entende que o objeto é o próprio VBox
        this.getChildren().add(scoreText);
        this.getChildren().add(gameOver); // Adicionando o label Game Over ao VBox
        this.getChildren().add(tryAgainButton);

        this.setAlignment(Pos.CENTER); // Alinha todos os elementos do VBox ao Centro

    }

}
