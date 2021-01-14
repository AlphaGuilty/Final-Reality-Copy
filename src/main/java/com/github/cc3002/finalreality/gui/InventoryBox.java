package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.Controller.Controller;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InventoryBox {


    public static void display(Controller c){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Inventory Menu");

        HBox hbox = new HBox(10);

        Label text = new Label("Weapon:");
        text.setFont(Font.font(15));
        hbox.getChildren().add(text);

        for(Weapon e : c.lookInventory()){
            VBox vbox = new VBox(5);
            hbox.getChildren().add(vbox);

            Label b1 = new Label(e.getName());
            b1.setFont(Font.font(12));
            Label b2 = new Label("Name: "+e.getName()+"\n"+
                    "Attack: "+e.getDamage()+"\n"+
                    "Weight: "+e.getWeight());
            Label b3 = new Label(" ");
            vbox.getChildren().addAll(b1,b2,b3);
        }

        Scene scene = new Scene(hbox);
        window.setScene(scene);
        window.showAndWait();
    }

}
