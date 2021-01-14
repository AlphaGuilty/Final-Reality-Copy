package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PartyTeamTest {
    protected BlockingQueue<ICharacter> turns;
    protected PartyTeam party;
    protected Thief testCharacter;
    protected String testName = "test";
    protected String testNameWeapon = "testWeapon";
    protected Knife testWeapon;

    @BeforeEach
    void setUp() {

        party = new PartyTeam(turns);
        testCharacter = new Thief(testName,turns);
        testCharacter.setDef(10);
        testCharacter.setLife(20);
        testWeapon = new Knife(testNameWeapon,10,20);
    }

    @Test
    void getTeam() {
        List<AbstractPlayerCharacter> testList = new ArrayList<>();
        assertTrue(party.getTeam().isEmpty());
        party.addTeammate(testCharacter);
        testList.add(testCharacter);
        assertEquals(party.getTeam(),testList);
    }

    @Test
    void addTeammate() {
        assertTrue(party.getTeam().isEmpty());
        party.addTeammate(testCharacter);
        assertFalse(party.getTeam().isEmpty());
        assertEquals(party.getTeammate(testName),testCharacter);
    }

    @Test
    void removeTeammate() {
        party.addTeammate(testCharacter);
        assertEquals(party.getTeammate(testName),testCharacter);
        party.removeTeammate(testCharacter);
        assertTrue(party.getTeam().isEmpty());
    }

    @Test
    void getTeammate() {
        party.addTeammate(testCharacter);
        assertEquals(testCharacter,party.getTeammate(testName));
        assertNull(party.getTeammate("No Name"));
    }

    @Test
    void equipWeaponTo() {
        party.addTeammate(testCharacter);
        party.equipWeaponTo(testCharacter, testWeapon);
        assertEquals(party.getTeammate(testName).getEquippedWeapon(), testWeapon);
    }

    @Test
    void checkLife() {
        party.addTeammate(testCharacter);
        assertEquals(party.checkLife(testCharacter),20);
    }

    @Test
    void checkDef() {
        party.addTeammate(testCharacter);
        assertEquals(party.checkDef(testCharacter),10);
    }

    @Test
    void checkAtk() {
        party.addTeammate(testCharacter);
        party.equipWeaponTo(testCharacter,testWeapon);
        assertEquals(party.checkAtk(testCharacter),10);

    }

    @Test
    void checkWeapon() {
        party.addTeammate(testCharacter);
        party.equipWeaponTo(testCharacter,testWeapon);
        assertEquals(party.checkWeapon(testCharacter),testWeapon);
    }

    @Test
    void getInventoryWeapons() {
        assertTrue(party.getInventoryWeapons().isEmpty());
        party.addWeaponToInventory(testWeapon);
        List<Weapon> invWeapons = new ArrayList<>();
        invWeapons.add(testWeapon);
        assertEquals(invWeapons,party.getInventoryWeapons());
    }

    @Test
    void addWeaponToInventory() {
        assertTrue(party.getInventoryWeapons().isEmpty());
        party.addWeaponToInventory(testWeapon);
        assertEquals(party.getInventoryWeapons().get(0),testWeapon);
    }

    @Test
    void removeWeaponToInventory() {
        assertTrue(party.getInventoryWeapons().isEmpty());
        party.addWeaponToInventory(testWeapon);
        assertFalse(party.getInventoryWeapons().isEmpty());
        party.removeWeaponToInventory(testWeapon);
        assertTrue(party.getInventoryWeapons().isEmpty());
    }

    @Test
    void createTeammate() {
        BlackMage a = new BlackMage("1",turns);
        a.setLife(10);
        a.setDef(20);
        Engineer b = new Engineer("2",turns);
        b.setLife(10);
        b.setDef(20);
        Knight c = new Knight("3",turns);
        c.setLife(10);
        c.setDef(20);
        WhiteMage d = new WhiteMage("4",turns);
        d.setLife(10);
        d.setDef(20);
        Thief e = new Thief("5",turns);
        e.setLife(10);
        e.setDef(20);

        assertEquals(party.createTeammate("1",10,20,"BlackMage"),a);
        assertEquals(party.createTeammate("2",10,20,"Engineer"),b);
        assertEquals(party.createTeammate("3",10,20,"Knight"),c);
        assertEquals(party.createTeammate("4",10,20,"WhiteMage"),d);
        assertEquals(party.createTeammate("5",10,20,"Thief"),e);

    }

    @Test
    void isInTeam() {
        assertTrue(party.getTeam().isEmpty());
        party.addTeammate(testCharacter);
        assertTrue(party.isInTeam(testName));
        assertFalse(party.isInTeam("No Name"));
    }


}




