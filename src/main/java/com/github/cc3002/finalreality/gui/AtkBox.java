package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.Controller.Controller;
import com.github.cc3002.finalreality.model.character.Enemy;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AtkBox {

    private static Enemy res = null;

    public static Enemy display(Controller c){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Attack Menu");
        window.setMinWidth(150);
        window.setOnCloseRequest(event -> res = null );

        VBox vbox = new VBox(5);
        vbox.setAlignment(Pos.CENTER);

        Label text = new Label("Select target:");
        text.setFont(Font.font(15));
        vbox.getChildren().add(text);

        for(Enemy e : c.seeEnemies()){
            Button b = new Button(e.getName());
            vbox.getChildren().add(b);
            b.setOnAction(event -> {res = e;
            window.close();});
        }

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();

        return res;
    }
}
