package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.Controller.Controller;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangeWeaponBox {


    public static void display(Controller c){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Change Weapon Menu");
        window.setMinWidth(150);

        VBox vbox = new VBox(5);
        vbox.setAlignment(Pos.CENTER);

        Label text = new Label("Select Weapon:");
        text.setFont(Font.font(15));
        vbox.getChildren().add(text);

        for(Weapon e : c.ValidWeapon(c.getTeammate(c.getTurnPlayer()),c.lookInventoryPlayer())){
            Button b = new Button(e.getName());
            vbox.getChildren().add(b);
            b.setOnAction(event -> {
                c.equipWeaponTo(c.getTeammate(c.getTurnPlayer()),e);
                window.close()
                ;
            });
        }

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();
    }

}
