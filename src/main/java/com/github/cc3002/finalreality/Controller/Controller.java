package com.github.cc3002.finalreality.Controller;


import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *  * A class that holds all the information of the Controller.
 * @author Tomas Secul.
 */


public class Controller implements IController {
    protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
    private final PartyTeam party = new PartyTeam(turns);
    private final EnemyTeam enemies = new EnemyTeam(turns);
    private String TurnPlayer = null;
    private final Data data = new Data();


    /**
     * Returns the PartyTeam.
     */
    public PartyTeam getParty() {
        return party;
    }

    /**
     * Returns the TurnPlayer.
     */
    public String getTurnPlayer(){
        return TurnPlayer;
    }

    /**
     * Returns the EnemiesTeam.
     */
    public EnemyTeam getEnemies() {
        return enemies;
    }

    /**
     * Returns the BlockingQueue<ICharacter> with the turns.
     */
    public BlockingQueue<ICharacter> getTurns() {
        return turns;
    }

    @Override
    public void addTeammate(AbstractPlayerCharacter teammate){
        party.addTeammate(teammate);
    }

    @Override
    public AbstractPlayerCharacter createTeammate(String name, String type, Integer life, Integer def){
        AbstractPlayerCharacter character = party.createTeammate(name, life, def, type);
        character.setData(data);
        return character;
    }

    @Override
    public void removeTeammate(AbstractPlayerCharacter teammate){
        party.removeTeammate(teammate);
    }

    @Override
    public AbstractPlayerCharacter getTeammate(String name){
        return party.getTeammate(name);
    }

    @Override
    public void addEnemy(Enemy opponent){
        enemies.addTeammate(opponent);
    }

    @Override
    public Enemy createEnemy(String name, Integer weight, Integer atk, Integer life, Integer def){
        Enemy opponent = new Enemy(name, weight, turns);
        opponent.setAttack(atk);
        opponent.setLife(life);
        opponent.setDef(def);
        opponent.setData(data);
        return opponent; 
    }

    @Override
    public void removeEnemy(Enemy enemy){
        enemies.removeTeammate(enemy);
    }

    @Override
    public Enemy getEnemy(String name){
        return enemies.getOpponent(name);
    }

    @Override
    public Weapon createWeapon(String name, Integer atk, Integer weight, String type){
        Weapon weapon = null;
        switch (type) {
            case "Axe":
                weapon = new Axe(name, atk, weight);
                break;
            case "Bow":
                weapon = new Bow(name, atk, weight);
                break;
            case "Knife":
                weapon = new Knife(name, atk, weight);
                break;
            case "Staff":
                weapon = new Staff(name, atk, weight);
                break;
            case "Sword":
                weapon = new Sword(name, atk, weight);
                break;
        }
        return weapon;
    }

    @Override
    public void addWeaponToInventory(Weapon weapon){
        party.addWeaponToInventory(weapon);
    }

    @Override
    public void removeWeaponToInventory(Weapon weapon){
        party.removeWeaponToInventory(weapon);
    }

    @Override
    public List<AbstractPlayerCharacter> seeParty(){
        return party.getTeam();
    }

    @Override
    public List<Enemy> seeEnemies(){
        return enemies.getTeam();
    }

    @Override
    public List<Weapon> lookInventory(){
        return party.getInventoryWeapons();
    }


    public List<Weapon> lookInventoryPlayer(){
        return party.getInventoryWeaponsPlayer();
    }

    @Override
    public int checkAtk(AbstractPlayerCharacter teammate){
        return party.checkAtk(teammate);
    }

    @Override
    public int checkAtk(Enemy enemy){
        return enemies.checkAtk(enemy);
    }

    @Override
    public int checkDef(AbstractPlayerCharacter teammate){
        return party.checkDef(teammate);
    }

    @Override
    public int checkDef(Enemy enemy){
        return enemies.checkDef(enemy);
    }

    @Override
    public int  checkLife(AbstractPlayerCharacter teammate){
        return party.checkLife(teammate);
    }

    @Override
    public int checkLife(Enemy enemy){
        return enemies.checkLife(enemy);
    }

    @Override
    public Weapon checkWeapon(AbstractPlayerCharacter teammate){
        return party.checkWeapon(teammate);
    }

    @Override
    public void equipWeaponTo(AbstractPlayerCharacter teammate, Weapon weapon){
        party.equipWeaponTo(teammate, weapon);
    }

    @Override
    public void attack(AbstractPlayerCharacter teammate, Enemy enemy){
        if(!party.isInTeam(teammate.getName())){endTurn();}
        enemy.receiveAttack(teammate);
        endTurn();
        if(enemy.getLife() == 0){enemies.removeTeammate(enemy);}
    }

    @Override
    public void attack(Enemy enemy, AbstractPlayerCharacter teammate){
        if(!enemies.isInTeam(enemy.getName())){endTurn();}
        teammate.receiveAttack(enemy);
        endTurn();
        if(teammate.getLife() == 0){
            party.addWeaponToInventory(teammate.getEquippedWeapon());
            party.removeTeammate(teammate);
        }

    }

    @Override
    public void buildBattle(){
        for (AbstractPlayerCharacter i : party.getTeam()){
            i.waitTurn();
        }
        for (Enemy i : enemies.getTeam()){
            i.waitTurn();
        }
        data.receive();
        ICharacter aux = turns.poll();
        TurnPlayer = aux.getName();

    }

    @Override
    public void endTurn(){
        if(party.isInTeam(TurnPlayer)){
            party.getTeammate(TurnPlayer).waitTurn();
        }
        else if(enemies.isInTeam(TurnPlayer)){
            enemies.getOpponent(TurnPlayer).waitTurn();
        }
        if(!(turns.isEmpty())){data.send();}
        data.receive();
        ICharacter aux = turns.poll();
        TurnPlayer = aux.getName();}

    public void pass(){
        data.receive();
        ICharacter aux = turns.poll();
        TurnPlayer = aux.getName();
    }



    @Override
    public boolean wonParty(){
        return enemies.getTeam().isEmpty();
    }

    @Override
    public boolean wonEnemies(){
        return party.getTeam().isEmpty();
    }


    public List<Weapon> ValidWeapon(AbstractPlayerCharacter teammate, List<Weapon> list) {

        return teammate.ValidWeapon(list);
    }

    public Data getData() {
        return data;
    }
}