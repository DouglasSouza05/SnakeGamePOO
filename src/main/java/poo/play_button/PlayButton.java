package poo.play_button;

import poo.config.Config;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PlayButton extends VBox {

    public PlayButton(EventHandler<ActionEvent> playAction) {

        Button play = new Button("JOGAR");
        play.setFont(Font.font(60));
        play.setOnAction(playAction);

        // Setando o tamanho do VBox igual ao tamanha da scene. Auxilia na hora de
        // centralizar o label
        this.setMinWidth(Config.width);
        this.setMinHeight(Config.height);

        this.getChildren().add(play);

        this.setAlignment(Pos.CENTER);
    }

}
