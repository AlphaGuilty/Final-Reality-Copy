package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    protected Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller();
    }


    @Test
    void addTeammate() {
        assertTrue(controller.getParty().getTeam().isEmpty());
        controller.addTeammate(controller.createTeammate("pepe","Thief",10,50));
        assertFalse(controller.getParty().getTeam().isEmpty());
        assertEquals(controller.getParty().getTeammate("pepe"),
                controller.createTeammate("pepe","Thief",10,50));
    }

    @Test
    void createTeammate() {
        Thief test = new Thief("pepe",controller.getTurns());
        test.setDef(50);
        test.setLife(10);
        assertEquals(controller.createTeammate("pepe","Thief",10,50),test);
    }

    @Test
    void removeTeammate() {
        assertTrue(controller.getParty().getTeam().isEmpty());
        controller.addTeammate(controller.createTeammate("pepe","Thief",10,50));
        assertFalse(controller.getParty().getTeam().isEmpty());
        controller.removeTeammate(controller.getTeammate("pepe"));
        assertTrue(controller.getParty().getTeam().isEmpty());
    }

    @Test
    void getTeammate() {
        var test = controller.createTeammate("pepe","Thief",10,50);
        assertTrue(controller.getParty().getTeam().isEmpty());
        controller.addTeammate(test);
        assertEquals(test,controller.getTeammate("pepe"));
    }

    @Test
    void addEnemy() {
        assertTrue(controller.getEnemies().getTeam().isEmpty());
        controller.addEnemy(controller.createEnemy("zac",20,10,30,50));
        assertFalse(controller.getEnemies().getTeam().isEmpty());
        assertEquals(controller.getEnemies().getOpponent("zac"),
                controller.createEnemy("zac",20,10,30,50));
    }

    @Test
    void createEnemy() {
        Enemy test = new Enemy("zac",20,controller.getTurns());
        test.setAttack(10);
        test.setDef(50);
        test.setLife(30);
        assertEquals(controller.createEnemy("zac",20,10,30,50),test);
    }

    @Test
    void removeEnemy() {
        assertTrue(controller.getEnemies().getTeam().isEmpty());
        controller.addEnemy(controller.createEnemy("zac",20,10,30,50));
        assertFalse(controller.getEnemies().getTeam().isEmpty());
        controller.removeEnemy(controller.getEnemy("zac"));
        assertTrue(controller.getEnemies().getTeam().isEmpty());
    }

    @Test
    void getEnemy() {
        var test = controller.createEnemy("zac",20,10,30,50);
        assertTrue(controller.getEnemies().getTeam().isEmpty());
        controller.addEnemy(test);
        assertEquals(test,controller.getEnemy("zac"));
    }

    @Test
    void createWeapon() {
        assertEquals(controller.createWeapon("Fire",1,2,"Axe"),new Axe("Fire",1,2));
        assertEquals(controller.createWeapon("Fire",1,2,"Bow"),new Bow("Fire",1,2));
        assertEquals(controller.createWeapon("Fire",1,2,"Knife"),new Knife("Fire",1,2));
        assertEquals(controller.createWeapon("Fire",1,2,"Staff"),new Staff("Fire",1,2));
        assertEquals(controller.createWeapon("Fire",1,2,"Sword"),new Sword("Fire",1,2));
    }

    @Test
    void addWeaponToInventory() {
        assertTrue(controller.lookInventory().isEmpty());
        controller.addWeaponToInventory(controller.createWeapon("Fire",1,2,"Bow"));
        assertEquals(controller.lookInventory().get(0),controller.createWeapon("Fire",1,2,"Bow"));
    }

    @Test
    void removeWeaponToInventory() {
        assertTrue(controller.lookInventory().isEmpty());
        controller.addWeaponToInventory(controller.createWeapon("Fire",1,2,"Bow"));
        assertFalse(controller.lookInventory().isEmpty());
        controller.removeWeaponToInventory(controller.createWeapon("Fire",1,2,"Bow"));
        assertTrue(controller.lookInventory().isEmpty());
    }

    @Test
    void seeParty() {
        assertTrue(controller.seeParty().isEmpty());
        controller.addTeammate(controller.createTeammate("pepe","Thief",10,50));
        assertFalse(controller.seeParty().isEmpty());
        assertEquals(controller.seeParty().get(0),
                controller.createTeammate("pepe","Thief",10,50));
    }

    @Test
    void seeEnemies() {
        assertTrue(controller.seeEnemies().isEmpty());
        controller.addEnemy(controller.createEnemy("zac",20,10,30,50));
        assertFalse(controller.seeEnemies().isEmpty());
        assertEquals(controller.seeEnemies().get(0),
                controller.createEnemy("zac",20,10,30,50));
    }

    @Test
    void lookInventory() {
        assertTrue(controller.lookInventory().isEmpty());
        controller.addWeaponToInventory(controller.createWeapon("Fire",1,2,"Bow"));
        assertFalse(controller.lookInventory().isEmpty());
    }

    @Test
    void checkAtk() {
        controller.addTeammate(controller.createTeammate("pepe","Thief",10,50));
        controller.equipWeaponTo(controller.getTeammate("pepe"),controller.createWeapon("Fire",1,2,"Knife"));
        controller.addEnemy(controller.createEnemy("zac",20,10,30,50));
        assertEquals(controller.checkAtk(controller.getTeammate("pepe")),1);
        assertEquals(controller.checkAtk(controller.getEnemy("zac")),10);
    }

    @Test
    void checkDef() {
        controller.addTeammate(controller.createTeammate("pepe","Thief",10,50));
        controller.equipWeaponTo(controller.getTeammate("pepe"),controller.createWeapon("Fire",1,2,"Knife"));
        controller.addEnemy(controller.createEnemy("zac",20,10,30,50));
        assertEquals(controller.checkDef(controller.getTeammate("pepe")),50);
        assertEquals(controller.checkDef(controller.getEnemy("zac")),50);
    }

    @Test
    void checkLife() {
        controller.addTeammate(controller.createTeammate("pepe","Thief",10,50));
        controller.equipWeaponTo(controller.getTeammate("pepe"),controller.createWeapon("Fire",1,2,"Knife"));
        controller.addEnemy(controller.createEnemy("zac",20,10,30,50));
        assertEquals(controller.checkLife(controller.getTeammate("pepe")),10);
        assertEquals(controller.checkLife(controller.getEnemy("zac")),30);
    }

    @Test
    void checkWeapon() {
        controller.addTeammate(controller.createTeammate("pepe","Thief",10,50));
        controller.equipWeaponTo(controller.getTeammate("pepe"),controller.createWeapon("Fire",1,2,"Knife"));
        assertEquals(controller.createWeapon("Fire",1,2,"Knife"),controller.checkWeapon(controller.getTeammate("pepe")));
    }

    @Test
    void equipWeaponTo() {
        controller.addTeammate(controller.createTeammate("pepe","Thief",10,50));
        assertNull(controller.checkWeapon(controller.getTeammate("pepe")));
        controller.equipWeaponTo(controller.getTeammate("pepe"),controller.createWeapon("Fire",1,2,"Knife"));
        assertEquals(controller.createWeapon("Fire",1,2,"Knife"),controller.checkWeapon(controller.getTeammate("pepe")));    }



    @Test
    void buildBattle() {
        var test1 = controller.createTeammate("pepe","Thief",10,1);
        test1.equip(controller.createWeapon("Fire",10,2,"Knife"));
        var test2 = controller.createEnemy("zac",20,10,10,1);
        controller.addTeammate(test1);
        controller.addEnemy(test2);

        assertTrue(controller.getTurns().isEmpty());
        controller.buildBattle();
        controller.getData().receive();
        assertFalse(controller.getTurns().isEmpty());
        assertTrue(controller.getTurns().peek()==test2);
    }

    @Test
    void endTurn() {
        assertNull(controller.getTurnPlayer());
        var test1 = controller.createTeammate("pepe","Thief",10,1);
        test1.equip(controller.createWeapon("Fire",10,20,"Knife"));
        var test2 = controller.createEnemy("zac",30,10,10,1);
        controller.addTeammate(test1);
        controller.addEnemy(test2);
        controller.buildBattle();
        assertEquals(test1.getName(),controller.getTurnPlayer());
        controller.endTurn();
        assertEquals(test2.getName(),controller.getTurnPlayer());
    }

    @Test
    void pass() {
        assertNull(controller.getTurnPlayer());
        var test1 = controller.createTeammate("pepe","Thief",10,1);
        test1.equip(controller.createWeapon("Fire",10,20,"Knife"));
        var test2 = controller.createEnemy("zac",30,10,10,1);
        controller.addTeammate(test1);
        controller.addEnemy(test2);
        controller.buildBattle();
        assertEquals(test1.getName(),controller.getTurnPlayer());
        controller.pass();
        assertEquals(test2.getName(),controller.getTurnPlayer());
    }

    @Test
    void wonParty() {
    }

    @Test
    void wonEnemies() {
    }

    @Test
    void attack() {
        var test1 = controller.createTeammate("pepe","Thief",10,1);
        test1.equip(controller.createWeapon("Fire",10,20,"Knife"));
        var test2 = controller.createEnemy("zac",20,10,10,1);
        var test3 = controller.createTeammate("pepe","Thief",10,100);
        test3.equip(controller.createWeapon("Fire",1,20,"Knife"));
        var test4 = controller.createEnemy("zac",20,11,10,100);

        controller.addTeammate(test1);
        controller.addEnemy(test2);
        controller.buildBattle();
        assertEquals(controller.checkLife(controller.getTeammate("pepe")),10);
        controller.attack(controller.getEnemy("zac"),controller.getTeammate("pepe"));
        assertEquals(controller.checkLife(controller.getTeammate("pepe")),1);
        assertEquals(controller.checkLife(controller.getEnemy("zac")),10);
        controller.attack(controller.getTeammate("pepe"), controller.getEnemy("zac"));
        assertEquals(controller.checkLife(controller.getEnemy("zac")),1);

        assertEquals(test3.getLife(),10);
        controller.attack(test4,test3);
        assertEquals(test3.getLife(),9);
        assertEquals(test4.getLife(),10);
        controller.attack(test3,test4);
        assertEquals(test4.getLife(),9);

        assertFalse(controller.seeParty().isEmpty());
        assertFalse(controller.seeEnemies().isEmpty());
        controller.addTeammate(test3);
        controller.addEnemy(test4);
        controller.attack(test3,test2);
        controller.attack(test4,test1);
        controller.removeTeammate(test3);
        controller.removeEnemy(test4);
        assertTrue(controller.seeParty().isEmpty());
        assertTrue(controller.seeEnemies().isEmpty());

    }

    @Test
    void validWeapon(){
        AbstractPlayerCharacter knight = controller.createTeammate("Arthur", "Knight", 100, 50);
        AbstractPlayerCharacter thief = controller.createTeammate("Robin", "Thief", 100, 40);
        AbstractPlayerCharacter engineer = controller.createTeammate("Bob", "Engineer", 50, 60);
        AbstractPlayerCharacter blackmage = controller.createTeammate("Larry", "BlackMage", 100, 45);
        AbstractPlayerCharacter whitemage = controller.createTeammate("Iris", "WhiteMage", 200, 20);

        Weapon axe1 = controller.createWeapon("Archaic Axe", 100, 20, "Axe");
        Weapon bow1 = controller.createWeapon("Tactic Bow", 80, 15, "Bow");
        Weapon knife1 = controller.createWeapon("Pocket Knife", 60, 10, "Knife");
        Weapon staff1 = controller.createWeapon("Magic Wand", 50, 9, "Staff");
        Weapon sword1 = controller.createWeapon("Titanium Sword", 90, 23, "Sword");

        controller.addWeaponToInventory(axe1);
        controller.addWeaponToInventory(bow1);
        controller.addWeaponToInventory(knife1);
        controller.addWeaponToInventory(staff1);
        controller.addWeaponToInventory(sword1);

        List<Weapon> knight2 = new ArrayList<>();
        knight2.add(axe1);
        knight2.add(sword1);
        knight2.add(knife1);

        List<Weapon> thief2 = new ArrayList<>();
        thief2.add(knife1);
        thief2.add(sword1);
        thief2.add(bow1);

        List<Weapon> engineer2 = new ArrayList<>();
        engineer2.add(axe1);
        engineer2.add(bow1);

        List<Weapon> blackmage2 = new ArrayList<>();
        blackmage2.add(staff1);
        blackmage2.add(knife1);

        List<Weapon> whitemage2 = new ArrayList<>();
        whitemage2.add(staff1);

        List<Weapon> knight3 =controller.ValidWeapon(knight,controller.lookInventory());
        List<Weapon> thief3 = controller.ValidWeapon(thief,controller.lookInventory());
        List<Weapon> engineer3 = controller.ValidWeapon(engineer,controller.lookInventory());
        List<Weapon> blackmage3 = controller.ValidWeapon(blackmage,controller.lookInventory());
        List<Weapon> whitemage3 = controller.ValidWeapon(whitemage,controller.lookInventory());

        for (Weapon w : knight2){
            assertTrue(knight3.contains(w));
        }
        for (Weapon w : knight3){
            assertTrue(knight2.contains(w));
        }

        for (Weapon w : thief2){
            assertTrue(thief3.contains(w));
        }
        for (Weapon w : thief3){
            assertTrue(thief2.contains(w));
        }

        for (Weapon w : engineer2){
            assertTrue(engineer3.contains(w));
        }
        for (Weapon w : engineer3){
            assertTrue(engineer2.contains(w));
        }

        for (Weapon w : blackmage2){
            assertTrue(blackmage3.contains(w));
        }
        for (Weapon w : blackmage3){
            assertTrue(blackmage2.contains(w));
        }

        for (Weapon w : whitemage2){
            assertTrue(whitemage3.contains(w));
        }
        for (Weapon w : whitemage3){
            assertTrue(whitemage2.contains(w));
        }

    }

    @Test
    public void won(){
        assertTrue(controller.wonEnemies());
        assertTrue(controller.wonParty());
        controller.addTeammate(controller.createTeammate("test","Thief",1,1));
        controller.addEnemy(controller.createEnemy("test2",1,1,1,1));
        assertFalse(controller.wonEnemies());
        assertFalse(controller.wonParty());
    }

}