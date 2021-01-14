package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.*;

import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Tomas Secul
 */
class PlayerCharacterTest extends AbstractCharacterTest {

  private static final String BLACK_MAGE_NAME = "Vivi";
  private static final String KNIGHT_NAME = "Adelbert";
  private static final String WHITE_MAGE_NAME = "Eiko";
  private static final String ENGINEER_NAME = "Cid";
  private static final String THIEF_NAME = "Zidane";
  private Map<CharacterClass, String> characterNames;

  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();


    testCharacters.add(new BlackMage(BLACK_MAGE_NAME, turns));
    testCharacters.add(new Engineer(ENGINEER_NAME, turns));
    testCharacters.add(new Knight(KNIGHT_NAME, turns));
    testCharacters.add(new Thief(THIEF_NAME, turns));
    testCharacters.add(new WhiteMage(WHITE_MAGE_NAME, turns));



    /**

     for (var characterClass :
        characterNames.keySet()) {
      testCharacters.add(
          new PlayerCharacter(characterNames.get(characterClass), turns, characterClass));
    }*/
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTestAndEquals() {
    var enemy = new Enemy("Enemy", 10, turns);

    for (var character :
        testCharacters) {
      assertNotEquals(character, enemy);
      assertEquals(character,character);
    }
    /** equal en objetos duplicados (distintos objetos) */
    assertEquals(new BlackMage(BLACK_MAGE_NAME, turns),new BlackMage(BLACK_MAGE_NAME, turns));
    assertEquals(new Engineer(ENGINEER_NAME, turns),new Engineer(ENGINEER_NAME, turns));
    assertEquals(new Knight(KNIGHT_NAME, turns),new Knight(KNIGHT_NAME, turns));
    assertEquals(new Thief(THIEF_NAME, turns),new Thief(THIEF_NAME, turns));
    assertEquals(new WhiteMage(WHITE_MAGE_NAME, turns),new WhiteMage(WHITE_MAGE_NAME, turns));
    /** hashcode en objetos duplicados (distintos objetos) */

    assertEquals(new BlackMage(BLACK_MAGE_NAME, turns).hashCode(),new BlackMage(BLACK_MAGE_NAME, turns).hashCode());
    assertEquals(new Engineer(ENGINEER_NAME, turns).hashCode(),new Engineer(ENGINEER_NAME, turns).hashCode());
    assertEquals(new Knight(KNIGHT_NAME, turns).hashCode(),new Knight(KNIGHT_NAME, turns).hashCode());
    assertEquals(new Thief(THIEF_NAME, turns).hashCode(),new Thief(THIEF_NAME, turns).hashCode());
    assertEquals(new WhiteMage(WHITE_MAGE_NAME, turns).hashCode(),new WhiteMage(WHITE_MAGE_NAME, turns).hashCode());




  }

  @Test
  void equipWeaponTest() {
    for (var character :
        testCharacters) {
      assertNull(character.getEquippedWeapon());
      character.equip(testWeapon);
      assertEquals(testWeapon, character.getEquippedWeapon());
    }
  }

  @Test
  void checkClass() {
    assertEquals(new BlackMage(BLACK_MAGE_NAME, turns).getCharacterClass(), CharacterClass.BLACK_MAGE);
  }
}
