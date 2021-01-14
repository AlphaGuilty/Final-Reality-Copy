package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.Controller.Controller;
import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InfoBox {

    public static void display(Controller c){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Info Menu");
        window.setMinWidth(300);

        BorderPane pane = new BorderPane();

        VBox vbox = new VBox(5);
        vbox.setAlignment(Pos.CENTER);

        VBox vbox2 = new VBox(5);
        vbox2.setAlignment(Pos.CENTER);

        pane.setLeft(vbox);
        pane.setRight(vbox2);

        Label text = new Label("Info Party:\n"+" ");
        text.setFont(Font.font(20));
        vbox.getChildren().add(text);

        for(AbstractPlayerCharacter e : c.seeParty()){
            Label t1 = new Label("Name: "+e.getName());
            t1.setFont(Font.font(15));
            Label t2 = new Label("Life: "+e.getLife());
            Label t3 = new Label("Defense: "+e.getDef());
            Label t4 = new Label("Weapon: "+e.getEquippedWeapon().getName());
            Label t5 = new Label("Attack: "+e.getEquippedWeapon().getDamage());
            Label t6 = new Label("Weight: "+e.getEquippedWeapon().getWeight());
            Label t7 = new Label(" ");
            vbox.getChildren().addAll(t1,t2,t3,t4,t5,t6,t7);
        }

        Label text2 = new Label("Info Enemies:\n"+" ");
        text2.setFont(Font.font(20));
        vbox2.getChildren().add(text2);

        for(Enemy e : c.seeEnemies()){
            Label t1 = new Label("Name: "+e.getName());
            t1.setFont(Font.font(15));
            Label t2 = new Label("Attack: "+e.getAttack());
            Label t3 = new Label("Life: "+e.getLife());
            Label t4 = new Label("Defense: "+e.getDef());
            Label t5 = new Label(" ");
            vbox2.getChildren().addAll(t1,t2,t3,t4,t5);
        }

        Scene scene = new Scene(pane);
        window.setScene(scene);
        window.showAndWait();
    }
}
