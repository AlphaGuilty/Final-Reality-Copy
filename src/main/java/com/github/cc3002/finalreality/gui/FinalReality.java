package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.Controller.Controller;
import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.weapon.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author Tomas Secul
 */
public class FinalReality extends Application {

  Button start_button;
  Button next_turn;
  Controller controller = new Controller();
  Integer turns = 0;
  Integer nCharacters = 0;
  private AbstractPlayerCharacter knight;
  private AbstractPlayerCharacter engineer;
  private AbstractPlayerCharacter blackmage;
  private AbstractPlayerCharacter whitemage;
  private AbstractPlayerCharacter thief;
  private Enemy troll;
  private Enemy ogre;
  private Enemy slime;
  private Enemy witch;
  private Enemy beast;
  private Enemy werewolf;


  public static void main(String[] args) {
    launch(args);
  }
  private static final String RESOURCE_PATH = "src/main/resources/";

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Final reality");

    prebuild();

    /*
      All the BorderPane
    */
    BorderPane start_menu = new BorderPane();
    BorderPane battle_menu = new BorderPane();
    BorderPane enemy_menu = new BorderPane();
    BorderPane select_menu = new BorderPane();
    BorderPane select_menu2 = new BorderPane();


    /*
      All the Vbox of Custom Menu
     */
    VBox select_menu_custom = new VBox(10);
    select_menu_custom.setAlignment(Pos.CENTER);
    VBox select_menu_custom2 = new VBox(10);
    select_menu_custom2.setAlignment(Pos.CENTER);

    /*
      Loadings Screens
     */
    Label loading_battle = new Label("Loading Battle...");
    loading_battle.setAlignment(Pos.CENTER);

    Label loading_turn = new Label("Waiting Turn...");
    loading_turn.setAlignment(Pos.CENTER);

    /*
      All the Scene
     */
    Scene start = new Scene(start_menu, 400, 200);
    Scene battle = new Scene(battle_menu, 500, 300);
    Scene enemy_atk = new Scene(enemy_menu, 500, 300);
    Scene loading_scene = new Scene(loading_battle, 500, 300.001);
    Scene loading_scene_turn = new Scene(loading_turn, 500, 300.001);
    Scene select_party = new Scene(select_menu, 500, 300);
    Scene select_enemy = new Scene(select_menu2, 500, 300);
    Scene select_custom = new Scene(select_menu_custom, 500, 300);
    Scene select_custom2 = new Scene(select_menu_custom2, 800, 300);

    /*
      Vbox of Start Menu
     */
    VBox start_menu_center = new VBox(5);
    start_menu_center.setAlignment(Pos.CENTER);
    start_menu.setCenter(start_menu_center);

    /*
      HBox of enemies
     */
    HBox enemy_center = new HBox(20);
    enemy_center.setAlignment(Pos.CENTER);
    enemy_menu.setCenter(enemy_center);

    /*
      Vbox of select party and enemies
     */
    VBox select_center = new VBox(5);
    select_center.setAlignment(Pos.CENTER);
    select_menu.setCenter(select_center);

    VBox select_center2 = new VBox(5);
    select_center2.setAlignment(Pos.CENTER);
    select_menu2.setCenter(select_center2);

    /*
      Vbox center on battle menu
     */
    VBox battle_center = new VBox(5);
    battle_center.setAlignment(Pos.CENTER);
    battle_menu.setCenter(battle_center);

    /*
      Labels
     */
    Label turnof = new Label();
    battle_menu.setTop(turnof);

    Label turncount = new Label();

    Label atkE = new Label("Loading2");
    enemy_center.getChildren().add(atkE);

    Label selectparty = new Label("Select three characters:");
    select_center.getChildren().add(selectparty);

    Label selectenemy = new Label("Select three enemies:");
    select_center2.getChildren().add(selectenemy);

    /*
      Button for Attack
     */
    Button attack_button = new Button("Attack");
    battle_center.getChildren().add(attack_button);
    try {
      ImageView batalla = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "batalla.png")));
      batalla.setFitHeight(50);
      batalla.setFitWidth(50);
      attack_button.setGraphic(batalla);
    } catch (FileNotFoundException ignored) {
    }
    attack_button.setOnAction(event -> {
      Enemy target = AtkBox.display(controller);
      if(!(target == null)){
        primaryStage.setScene(loading_scene_turn);
        controller.attack(controller.getTeammate(controller.getTurnPlayer()),target);
        turnbattle(primaryStage,enemy_menu,battle_menu,enemy_atk,battle,atkE,turncount);}
    });

    /*
      Button for info
     */
    Button info_button = new Button("Info");
    battle_center.getChildren().add(info_button);
    info_button.setOnAction(event -> InfoBox.display(controller));
    try {
      ImageView buscar = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "buscar.png")));
      buscar.setFitHeight(50);
      buscar.setFitWidth(50);
      info_button.setGraphic(buscar);
    } catch (FileNotFoundException ignored) {
    }


    Button inv_button = new Button("Inventory");
    battle_center.getChildren().add(inv_button);
    try {
      ImageView buscar = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "mochila.png")));
      buscar.setFitHeight(50);
      buscar.setFitWidth(50);
      inv_button.setGraphic(buscar);
    } catch (FileNotFoundException ignored) {
    }
    inv_button.setOnAction(event -> {
      InventoryBox.display(controller);
      lifePanels(battle_menu);});

    /*
      Button for Change Weapon
     */
    Button change_weapon_button = new Button("Change Weapon");
    battle_center.getChildren().add(change_weapon_button);
    try {
      ImageView ciclo = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "ciclo.png")));
      ciclo.setFitHeight(50);
      ciclo.setFitWidth(50);
      change_weapon_button.setGraphic(ciclo);
    } catch (FileNotFoundException ignored) {
    }
    change_weapon_button.setOnAction(event -> {
      ChangeWeaponBox.display(controller);
      lifePanels(battle_menu);});




    /*
      Button for add Character
     */
    for (String e : Arrays.asList("Knight","Engineer","Thief","BlackMage","WhiteMage")) {
      Button b = new Button(e);
      b.setAlignment(Pos.CENTER);
      select_center.getChildren().add(b);
      switch (e) {
        case "Knight":
          b.setText(knight.getName()+" (Knight)");
          b.setOnAction(event -> {
                    select_center.getChildren().remove(b);
                    controller.addTeammate(knight);
                    nCharacters++;
                    if (nCharacters.equals(3)) {
                      nCharacters = 0;
                      primaryStage.setScene(select_enemy);
                    }
                  }
          );
          break;
        case "Engineer":
          b.setText(engineer.getName()+" (Engineer)");
          b.setOnAction(event -> {
                    select_center.getChildren().remove(b);
                    controller.addTeammate(engineer);
                    nCharacters++;
                    if (nCharacters.equals(3)) {
                      nCharacters = 0;
                      primaryStage.setScene(select_enemy);
                    }
                  }
          );
          break;
        case "Thief":
          b.setText(thief.getName()+" (Thief)");
          b.setOnAction(event -> {
                    select_center.getChildren().remove(b);
                    controller.addTeammate(thief);
                    nCharacters++;
                    if (nCharacters.equals(3)) {
                      nCharacters = 0;
                      primaryStage.setScene(select_enemy);
                    }
                  }
          );
          break;
        case "BlackMage":
          b.setText(blackmage.getName()+" (BlackMage)");
          b.setOnAction(event -> {
                    select_center.getChildren().remove(b);
                    controller.addTeammate(blackmage);
                    nCharacters++;
                    if (nCharacters.equals(3)) {
                      nCharacters = 0;
                      primaryStage.setScene(select_enemy);
                    }
                  }
          );
          break;
        case "WhiteMage":
          b.setText(whitemage.getName()+" (WhiteMage)");
          b.setOnAction(event -> {
                    select_center.getChildren().remove(b);
                    controller.addTeammate(whitemage);
                    nCharacters++;
                    if (nCharacters.equals(3)) {
                      nCharacters = 0;
                      primaryStage.setScene(select_enemy);
                    }
                  }
          );
          break;
      }
    }

    /*
      Button for add Enemy
     */
    for (String e : Arrays.asList("Troll","Ogre","Slime","Witch","Beast","Werewolf")) {
      Button b = new Button(e);
      b.setAlignment(Pos.CENTER);
      select_center2.getChildren().add(b);
      switch (e) {
        case "Troll":
          b.setOnAction(event -> {
                    select_center2.getChildren().remove(b);
                    controller.addEnemy(troll);
                    nCharacters++;
                    if (nCharacters.equals(3)) {
                      nCharacters = 0;
                      primaryStage.setScene(select_custom);
                    }
                  }
          );
          break;
        case "Ogre":
          b.setOnAction(event -> {
                    select_center2.getChildren().remove(b);
                    controller.addEnemy(ogre);
                    nCharacters++;
                    if (nCharacters.equals(3)) {
                      nCharacters = 0;
                      primaryStage.setScene(select_custom);
                    }
                  }
          );
          break;
        case "Slime":
          b.setOnAction(event -> {
                    select_center2.getChildren().remove(b);
                    controller.addEnemy(slime);
                    nCharacters++;
                    if (nCharacters.equals(3)) {
                      nCharacters = 0;
                      primaryStage.setScene(select_custom);
                    }
                  }
          );
          break;
        case "Witch":
          b.setOnAction(event -> {
                    select_center2.getChildren().remove(b);
                    controller.addEnemy(witch);
                    nCharacters++;
                    if (nCharacters.equals(3)) {
                      nCharacters = 0;
                      primaryStage.setScene(select_custom);
                    }
                  }
          );
          break;
        case "Werewolf":
          b.setOnAction(event -> {
                    select_center2.getChildren().remove(b);
                    controller.addEnemy(werewolf);
                    nCharacters++;
                    if (nCharacters.equals(3)) {
                      nCharacters = 0;
                      primaryStage.setScene(select_custom);
                    }
                  }
          );
          break;
        case "Beast":
          b.setOnAction(event -> {
                    select_center2.getChildren().remove(b);
                    controller.addEnemy(beast);
                    nCharacters++;
                    if (nCharacters.equals(3)) {
                      nCharacters = 0;
                      primaryStage.setScene(select_custom);
                    }
                  }
          );
          break;


      }
    }

    /*
      Next Turn Button
     */
    next_turn = new Button();
    next_turn.setText("Next Turn");
    next_turn.setAlignment(Pos.CENTER);
    try {
      ImageView flecha = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "flecha.png")));
      flecha.setFitHeight(50);
      flecha.setFitWidth(50);
      next_turn.setGraphic(flecha);
    } catch (FileNotFoundException ignored) {
    }
    enemy_center.getChildren().add(next_turn);
    next_turn.setOnAction(e -> {
      primaryStage.setScene(loading_scene_turn);
      turnbattle(primaryStage,enemy_menu,battle_menu,enemy_atk,battle,atkE,turncount);
    });

    /*
      Start the Game
     */
    start_button = new Button();
    start_button.setText("Start");
    start_button.setOnAction(e -> {primaryStage.setScene(select_party);
      primaryStage.setResizable(true);});
    start_menu_center.getChildren().addAll(start_button);

    /*
      Start the Battle
     */
    Button startBattle = new Button("Start");
    startBattle.setAlignment(Pos.CENTER);
    select_menu_custom.getChildren().add(startBattle);
    startBattle.setOnAction(event -> {
      primaryStage.setScene(loading_scene);
      controller.buildBattle();
      turnbattle(primaryStage,enemy_menu,battle_menu,enemy_atk,battle,atkE,turncount);
    });

    /*
      Custom Characters
     */
    Button startCustom = new Button("Custom");
    startCustom.setAlignment(Pos.CENTER);
    select_menu_custom.getChildren().add(startCustom);
    startCustom.setOnAction(event -> {
      customAll(select_menu_custom2,primaryStage,enemy_menu,battle_menu,enemy_atk,battle,atkE,turncount,loading_scene);
      primaryStage.setScene(select_custom2);});

    try {
      Image image = new Image(new FileInputStream(RESOURCE_PATH + "inicio.png"));
      start_menu.setBackground(new Background(new BackgroundImage(image,null,null,null,null)));
      primaryStage.setResizable(false);
    } catch (FileNotFoundException ignored) {
    }

    primaryStage.setScene(start);
    primaryStage.show();
  }

  /**
   * Method of enemy attack player
   */
  public void TurnEnemy(Stage primaryStage, BorderPane enemy_menu, Scene enemy_atk, Label atkE, Label turncount) {
    turns++;
    String r = randomAtk();
    atkE.setText(r);
    turncount.setText("N Turns: "+ turns);
    enemy_menu.setBottom(turncount);
    primaryStage.setScene(enemy_atk);

  }

  /**
   * PreBuild Some Characters, Enemies and Weapons
   */
  public void prebuild() {
    knight = controller.createTeammate("Arthur","Knight",100,50);
    thief = controller.createTeammate("Robin","Thief",100,40);
    engineer = controller.createTeammate("Bob","Engineer",50,60);
    blackmage = controller.createTeammate("Larry", "BlackMage",100,45);
    whitemage = controller.createTeammate("Iris", "WhiteMage",200,20);

    Weapon axe1 = controller.createWeapon("Archaic Axe", 100, 20, "Axe");
    Weapon axe2 = controller.createWeapon("Diamond Axe", 150, 35, "Axe");
    Weapon bow1 = controller.createWeapon("Tactic Bow", 80, 15, "Bow");
    Weapon bow2 = controller.createWeapon("Phoenix Bow", 110, 25, "Bow");
    Weapon knife1 = controller.createWeapon("Pocket Knife", 60, 10, "Knife");
    Weapon knife2 = controller.createWeapon("Dagger", 80, 15, "Knife");
    Weapon staff1 = controller.createWeapon("Magic Wand", 50, 9, "Staff");
    Weapon staff2 = controller.createWeapon("Dark Matter Staff", 120, 30, "Staff");
    Weapon sword1 = controller.createWeapon("Titanium Sword", 90, 23, "Sword");
    Weapon sword2 = controller.createWeapon("Master Sword", 200, 45, "Sword");

    controller.addWeaponToInventory(axe1);
    controller.addWeaponToInventory(axe2);
    controller.addWeaponToInventory(bow1);
    controller.addWeaponToInventory(bow2);
    controller.addWeaponToInventory(knife1);
    controller.addWeaponToInventory(knife2);
    controller.addWeaponToInventory(staff1);
    controller.addWeaponToInventory(staff2);
    controller.addWeaponToInventory(sword1);
    controller.addWeaponToInventory(sword2);

    controller.equipWeaponTo(knight, sword1);
    controller.equipWeaponTo(thief, knife1);
    controller.equipWeaponTo(engineer, axe1);
    controller.equipWeaponTo(blackmage, staff2);
    controller.equipWeaponTo(whitemage, staff1);

    slime = controller.createEnemy("Slime",15,60,300,45);
    troll = controller.createEnemy("Troll",30,70,200,55);
    beast = controller.createEnemy("Beast",20,90,220,35);
    ogre = controller.createEnemy("Ogre",400,999,300,50);
    witch = controller.createEnemy("Witch", 40,100,250,60);
    werewolf = controller.createEnemy("Werewolf", 120, 110, 500, 60);
  }

  /**
   * Method Enemy attack random
   */
  public String randomAtk() {
    Random r = new Random();
    AbstractPlayerCharacter atkPerson = controller.seeParty().get(r.nextInt(controller.seeParty().size()));
    int vida = atkPerson.getLife();
    String res = controller.getTurnPlayer() + " attack "+ atkPerson.getName()+ "\n"+"(Life: "+vida+" -> ";
    controller.attack(controller.getEnemy(controller.getTurnPlayer()), atkPerson);
    res += atkPerson.getLife()+")";
    return res;
  }

  /**
   * Method admin turns
   */
  public void turnbattle(Stage primaryStage, BorderPane enemy_menu, BorderPane battle_menu, Scene enemy_atk, Scene battle, Label atkE, Label turncount){
    if(controller.wonEnemies()){
      try {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane,500,300);
        Image image = new Image(new FileInputStream(RESOURCE_PATH + "lost.png"));
        pane.setBackground(new Background(new BackgroundImage(image,null,null,null,null)));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        return;
      } catch (FileNotFoundException o) {
        Label lose = new Label("Game Over");
        lose.setFont(Font.font(30));
        lose.setAlignment(Pos.CENTER);
        Scene scene = new Scene(lose,500,300);
        primaryStage.setScene(scene);
        return;
      }
    }
    if(controller.wonParty()){
      try {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane,500,300);
        Image image = new Image(new FileInputStream(RESOURCE_PATH + "win.png"));
        pane.setBackground(new Background(new BackgroundImage(image,null,null,null,null)));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        return;
      } catch (FileNotFoundException o) {
        Label win = new Label("YOU WIN!!");
        win.setFont(Font.font(30));
        win.setAlignment(Pos.CENTER);
        Scene scene = new Scene(win,500,300);
        primaryStage.setScene(scene);
        return;
      }
    }

    if(controller.getParty().isInTeam(controller.getTurnPlayer())){
      turns++;
      lifePanels(battle_menu);
      primaryStage.setScene(battle);
    }
    else if (controller.getEnemies().isInTeam(controller.getTurnPlayer())){
      TurnEnemy(primaryStage,enemy_menu,enemy_atk,atkE,turncount);}
    else{controller.pass();
      turnbattle(primaryStage,enemy_menu,battle_menu,enemy_atk,battle,atkE,turncount);}
  }

  /**
   * Method admin info panel
   */
  public void lifePanels(BorderPane battle_menu){
    VBox info_party = new VBox(5);
    battle_menu.setLeft(info_party);
    VBox info_enem = new VBox(5);
    battle_menu.setRight(info_enem);
    Label isTurnof = new Label("Turn of: "+ controller.getTurnPlayer());
    isTurnof.setFont(Font.font(20));
    battle_menu.setTop(isTurnof);
    Label turncount = new Label();
    turncount.setText("N Turns: "+ turns);
    battle_menu.setBottom(turncount);

    for (AbstractPlayerCharacter e : controller.seeParty()){
      Label b = new Label();
      b.setText(e.getName()+"\n"+"Actual life: "+e.getLife());
      info_party.getChildren().add(b);
    }

    for (Enemy e : controller.seeEnemies()){
      Label b = new Label();
      b.setText(e.getName()+"\n"+"Actual life: "+e.getLife());
      info_enem.getChildren().add(b);
    }

    Label space = new Label(" ");
    Label actualWeapon = new Label();
    actualWeapon.setText("Actual Weapon Stats:"+"\n"+
            "Name: "+controller.getTeammate(controller.getTurnPlayer()).getEquippedWeapon().getName()+"\n"+
            "Atk: "+controller.getTeammate(controller.getTurnPlayer()).getEquippedWeapon().getDamage()+"\n"+
            "Weight: "+controller.getTeammate(controller.getTurnPlayer()).getEquippedWeapon().getWeight()+"\n");
    info_party.getChildren().add(space);
    info_party.getChildren().add(actualWeapon);
  }

  /**
   * Method for create custom menu
   */
  public void customAll(VBox vbox, Stage primaryStage, BorderPane enemy_menu, BorderPane battle_menu, Scene enemy_atk, Scene battle, Label atkE, Label turncount, Scene loading_scene){
    Label text = new Label("Custom:");
    text.setAlignment(Pos.CENTER);
    text.setFont(Font.font(30));
    Label text2 = new Label("Custom Party:");
    text.setAlignment(Pos.CENTER);
    text.setFont(Font.font(20));
    Label text3 = new Label("Custom Enemies:");
    text.setAlignment(Pos.CENTER);
    text.setFont(Font.font(20));
    Label text4 = new Label("Custom Weapons:");
    text.setAlignment(Pos.CENTER);
    text.setFont(Font.font(20));
    HBox hbox1 = new HBox(5);
    hbox1.setAlignment(Pos.CENTER);
    HBox hbox2 = new HBox(5);
    hbox2.setAlignment(Pos.CENTER);
    HBox hbox3 = new HBox(5);
    hbox3.setAlignment(Pos.CENTER);
    vbox.getChildren().addAll(text,text2,hbox1,text3,hbox2,text4,hbox3);

    for (AbstractPlayerCharacter e : controller.seeParty()){
      Button b = new Button();
      b.setText(e.getName());
      hbox1.getChildren().add(b);
      b.setOnAction(event -> CustomBox.display(e));
    }

    for (Enemy e : controller.seeEnemies()){
      Button b = new Button();
      b.setText(e.getName());
      hbox2.getChildren().add(b);
      b.setOnAction(event -> CustomBox.display(e));
    }

    for (Weapon e : controller.lookInventoryPlayer()){
      Button b = new Button();
      b.setText(e.getName());
      hbox3.getChildren().add(b);
      b.setOnAction(event -> CustomBox.display(e));
    }

    for (AbstractPlayerCharacter e : controller.seeParty()){
      Weapon w = e.getEquippedWeapon();
      Button b = new Button();
      b.setText(w.getName());
      hbox3.getChildren().add(b);
      b.setOnAction(event -> CustomBox.display(w));
    }

    Button startBattle = new Button("Start");
    startBattle.setMinSize(100,50);
    startBattle.setFont(Font.font(20));
    startBattle.setAlignment(Pos.CENTER);
    vbox.getChildren().add(startBattle);
    startBattle.setOnAction(event -> {
      primaryStage.setScene(loading_scene);
      controller.buildBattle();
      turnbattle(primaryStage,enemy_menu,battle_menu,enemy_atk,battle,atkE,turncount);
    });
  }
}