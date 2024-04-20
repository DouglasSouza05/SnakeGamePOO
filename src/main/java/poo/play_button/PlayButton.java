package poo.play_button;

import poo.config.Config;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class PlayButton extends VBox {

    public PlayButton(EventHandler<ActionEvent> playAction) {

        // Título do jogo
        Text title = new Text("Snake Game");
        title.setFont(Font.font(60));
        title.setTranslateY(-80); // Move o título para cima
        title.setStyle("-fx-font-weight: bold;"); // Definindo o estilo Negrito

        Button play = new Button("Iniciar Tentativa");
        play.setFont(Font.font(40));
        play.setOnAction(playAction);
        play.setTranslateY(40);

        Text welcome = new Text(
                "Seja Bem-Vindo(a) ao Jogo!");
        welcome.setFont(Font.font(40));

        Text description = new Text(
                "Observações: \nMaças Valem 3 Pontos e Abacaxis Valem 1 Ponto!");
        description.setFont(Font.font(30));

        welcome.setTranslateY(-20);
        description.setTranslateY(-20);

        // Setando o tamanho do VBox igual ao tamanha da Scene. Auxilia na hora de
        // centralizar o Label
        this.setMinWidth(Config.width);
        this.setMinHeight(Config.height);

        this.setSpacing(20); // Espaçamento entre os elementos
        this.getChildren().addAll(title, description, play);

        this.setAlignment(Pos.CENTER);
    }

}
