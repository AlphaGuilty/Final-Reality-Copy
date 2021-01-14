package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTeamTest {
    protected BlockingQueue<ICharacter> turns;
    protected EnemyTeam enemies;
    protected Enemy testEnemy;
    protected String testName = "test";

    @BeforeEach
    void setUp() {

        enemies = new EnemyTeam(turns);
        testEnemy = new Enemy(testName, 10, turns);
        testEnemy.setAttack(30);
        testEnemy.setDef(10);
        testEnemy.setLife(20);
    }

    @Test
    void getTeam(){
        List<Enemy> testList = new ArrayList<>();
        assertTrue(enemies.getTeam().isEmpty());
        enemies.addTeammate(testEnemy);
        testList.add(testEnemy);
        assertEquals(enemies.getTeam(),testList);
    }

    @Test
    void addTeammate() {
        assertTrue(enemies.getTeam().isEmpty());
        enemies.addTeammate(testEnemy);
        assertFalse(enemies.getTeam().isEmpty());
        assertEquals(enemies.getOpponent(testName),testEnemy);
    }

    @Test
    void removeTeammate() {
        enemies.addTeammate(testEnemy);
        assertEquals(enemies.getOpponent(testName),testEnemy);
        enemies.removeTeammate(testEnemy);
        assertTrue(enemies.getTeam().isEmpty());
    }

    @Test
    void getOpponent() {
        enemies.addTeammate(testEnemy);
        assertEquals(testEnemy,enemies.getOpponent(testName));
        assertNull(enemies.getOpponent("No Name"));
    }

    @Test
    void checkLife() {
        enemies.addTeammate(testEnemy);
        assertEquals(enemies.checkLife(testEnemy),20);
    }

    @Test
    void checkDef() {
        enemies.addTeammate(testEnemy);
        assertEquals(enemies.checkDef(testEnemy),10);
    }

    @Test
    void checkAtk() {
        enemies.addTeammate(testEnemy);
        assertEquals(enemies.checkAtk(testEnemy),30);
    }

    @Test
    void isInTeam() {
        assertTrue(enemies.getTeam().isEmpty());
        enemies.addTeammate(testEnemy);
        assertTrue(enemies.isInTeam(testName));
        assertFalse(enemies.isInTeam("No Name"));
    }
}