package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EnemyTest extends AbstractCharacterTest {

  protected Enemy testEnemy;
  protected Enemy testEnemy2;
  protected Thief testPlayerCharacter;

  private static final String ENEMY_NAME = "Goblin";

  @BeforeEach
  void setUp() {
    basicSetUp();
    testEnemy = new Enemy(ENEMY_NAME, 10, turns);
    testEnemy2 = new Enemy(ENEMY_NAME, 10, turns);
    testPlayerCharacter = new Thief(ENEMY_NAME, turns);
  }

  @Test
  void constructorTest() {
    assertEquals(testEnemy, testEnemy2);
    assertNotEquals(testEnemy, testPlayerCharacter);
    assertEquals(testEnemy, testEnemy);
    assertEquals(testEnemy.hashCode(), testEnemy.hashCode());

    assertEquals(testEnemy.getWeight(), 10);
    testEnemy.setWeight(20);
    assertEquals(testEnemy.getWeight(), 20);
  }

  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    testEnemy.waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(850);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(250);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testEnemy, turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}