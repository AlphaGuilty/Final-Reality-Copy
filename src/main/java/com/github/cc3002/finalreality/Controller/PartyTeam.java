package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;

import java.util.ArrayList;
import java.util.List;

/**
 *  * A class that holds all the information of Party.
 * @author Tomas Secul.
 */


public class PartyTeam implements IPartyTeam {
    private final List<AbstractPlayerCharacter> pTeam = new ArrayList<>();
    private final List<Weapon> invWeapons = new ArrayList<>();
    private final List<Weapon> totalInvWeapons = new ArrayList<>();
    protected BlockingQueue<ICharacter> turns;

    public PartyTeam(BlockingQueue<ICharacter> turns){
        this.turns = turns;
    }

    @Override
    public List<AbstractPlayerCharacter> getTeam() {
        return pTeam;
    }

    @Override
    public void addTeammate(AbstractPlayerCharacter teammate){
        pTeam.add(teammate);
    }

    @Override
    public void removeTeammate(AbstractPlayerCharacter teammate){
        pTeam.remove(teammate);
    }

    @Override
    public AbstractPlayerCharacter getTeammate(String name){
        for (AbstractPlayerCharacter teammate : pTeam){
            if(name.equals(teammate.getName())){return teammate;}
        }
        return null;
    }

    @Override
    public int checkLife(AbstractPlayerCharacter teammate){
        return teammate.getLife();
    }

    @Override
    public int checkDef(AbstractPlayerCharacter teammate){
        return teammate.getDef();
    }

    @Override
    public int checkAtk(AbstractPlayerCharacter teammate){
        return teammate.getEquippedWeapon().getDamage();
    }

    @Override
    public Weapon checkWeapon(AbstractPlayerCharacter teammate) {return teammate.getEquippedWeapon();}

    @Override
    public List<Weapon> getInventoryWeapons(){
        return totalInvWeapons;
    }

    public List<Weapon> getInventoryWeaponsPlayer(){
        return invWeapons;
    }

    @Override
    public void addWeaponToInventory(Weapon weapon){
        invWeapons.add(weapon);
        totalInvWeapons.add(weapon);
    }

    @Override
    public void removeWeaponToInventory(Weapon weapon){
        invWeapons.remove(weapon);
        totalInvWeapons.remove(weapon);
    }

    @Override
    public AbstractPlayerCharacter createTeammate(String name, Integer life, Integer def, String type){
        AbstractPlayerCharacter teammate = null;
        if(type.equals("BlackMage")){
            teammate = new BlackMage(name,turns);
        }

        else if(type.equals("Engineer")){
            teammate = new Engineer(name,turns);
        }

        else if(type.equals("Knight")){
            teammate = new Knight(name,turns);
        }

        else if(type.equals("WhiteMage")){
            teammate = new WhiteMage(name,turns);
        }

        else if(type.equals("Thief")){
            teammate = new Thief(name,turns);
        }
        teammate.setLife(life);
        teammate.setDef(def);
        return teammate;
    }

    @Override
    public boolean isInTeam(String name){
        if(name==null){return false;}
        for (AbstractPlayerCharacter teammate : pTeam){
            if(name.equals(teammate.getName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void equipWeaponTo(AbstractPlayerCharacter teammate, Weapon weapon){
        if(!(teammate.getEquippedWeapon() == null)){
            invWeapons.add(teammate.getEquippedWeapon());
        }
        teammate.equip(weapon);
        invWeapons.remove(weapon);
    }

}
