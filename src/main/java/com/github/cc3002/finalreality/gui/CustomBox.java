package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomBox {

    public static void display(AbstractPlayerCharacter e) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Custom");
        window.setMinWidth(150);

        VBox vbox = new VBox(5);

        Label text = new Label("Custom " + e.getName() + ":");
        text.setFont(Font.font(15));
        vbox.getChildren().add(text);

        Label lifeText = new Label("Life:");
        vbox.getChildren().add(lifeText);

        TextField life = new TextField(Integer.toString(e.getLife()));
        vbox.getChildren().add(life);

        Label defText = new Label("Defense:");
        vbox.getChildren().add(defText);

        TextField def = new TextField(Integer.toString(e.getDef()));
        vbox.getChildren().add(def);

        Button ok = new Button("OK");
        ok.setAlignment(Pos.CENTER);
        vbox.getChildren().add(ok);
        ok.setOnAction(event -> {if(ChangePlayer(e,life,def)){window.close();}});


        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void display(Enemy e) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Custom");
        window.setMinWidth(150);

        VBox vbox = new VBox(5);

        Label text = new Label("Custom " + e.getName() + ":");
        text.setFont(Font.font(15));
        vbox.getChildren().add(text);

        Label attackText = new Label("Attack:");
        vbox.getChildren().add(attackText);

        TextField attack = new TextField(Integer.toString(e.getAttack()));
        vbox.getChildren().add(attack);

        Label lifeText = new Label("Life:");
        vbox.getChildren().add(lifeText);

        TextField life = new TextField(Integer.toString(e.getLife()));
        vbox.getChildren().add(life);

        Label defText = new Label("Defense:");
        vbox.getChildren().add(defText);

        TextField def = new TextField(Integer.toString(e.getDef()));
        vbox.getChildren().add(def);

        Label weightText = new Label("Weight:");
        vbox.getChildren().add(weightText);

        TextField weight = new TextField(Integer.toString(e.getWeight()));
        vbox.getChildren().add(weight);

        Button ok = new Button("OK");
        ok.setAlignment(Pos.CENTER);
        vbox.getChildren().add(ok);
        ok.setOnAction(event -> {if(ChangeEnemy(e,attack,life,def,weight)){window.close();}});


        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void display(Weapon e) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Custom");
        window.setMinWidth(150);

        VBox vbox = new VBox(5);

        Label text = new Label("Custom " + e.getName() + ":");
        text.setFont(Font.font(15));
        vbox.getChildren().add(text);

        Label attackText = new Label("Attack:");
        vbox.getChildren().add(attackText);

        TextField attack = new TextField(Integer.toString(e.getDamage()));
        vbox.getChildren().add(attack);

        Label weightText = new Label("Weight:");
        vbox.getChildren().add(weightText);

        TextField weight = new TextField(Integer.toString(e.getWeight()));
        vbox.getChildren().add(weight);

        Button ok = new Button("OK");
        ok.setAlignment(Pos.CENTER);
        vbox.getChildren().add(ok);
        ok.setOnAction(event -> {if(ChangeWeapon(e,attack,weight)){window.close();}});


        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();
    }

    private static boolean ChangeWeapon(Weapon weapon, TextField attack, TextField weight) {
        int atkNew;
        int weightNew;
        try{
            atkNew = Integer.parseInt(attack.getText());
        }catch (NumberFormatException e){
            attack.setText("NO A NUMBER");
            return false;
        }
        try{
            weightNew = Integer.parseInt(weight.getText());
        }catch (NumberFormatException e){
            weight.setText("NO A NUMBER");
            return false;
        }
        weapon.setWeight(weightNew);
        weapon.setDamage(atkNew);
        return true;

    }

    private static boolean ChangeEnemy(Enemy enemy, TextField attack, TextField life, TextField def, TextField weight) {
        int atkNew;
        int lifeNew;
        int defNew;
        int weightNew;
        try{
            atkNew = Integer.parseInt(attack.getText());
        }catch (NumberFormatException e){
            attack.setText("NO A NUMBER");
            return false;
        }
        try{
            lifeNew = Integer.parseInt(life.getText());
        }catch (NumberFormatException e){
            life.setText("NO A NUMBER");
            return false;
        }
        try{
            defNew = Integer.parseInt(def.getText());
        }catch (NumberFormatException e){
            def.setText("NO A NUMBER");
            return false;
        }
        try{
            weightNew = Integer.parseInt(weight.getText());
        }catch (NumberFormatException e){
            weight.setText("NO A NUMBER");
            return false;
        }
        enemy.setLife(lifeNew);
        enemy.setDef(defNew);
        enemy.setAttack(atkNew);
        enemy.setWeight(weightNew);
        return true;
    }

    private static boolean  ChangePlayer(AbstractPlayerCharacter character, TextField life, TextField def) {
        int lifeNew;
        int defNew;
        try{
            lifeNew = Integer.parseInt(life.getText());
        }catch (NumberFormatException e){
            life.setText("NO A NUMBER");
            return false;
        }
        try{
            defNew = Integer.parseInt(def.getText());
        }catch (NumberFormatException e){
            def.setText("NO A NUMBER");
            return false;
        }
        character.setLife(lifeNew);
        character.setDef(defNew);
        return true;
    }


}
