package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.Weapon;

/**
 * This represents a character from the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Tomas Secul
 */
public interface ICharacter {

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's life.
   */
  public int getLife();

  /**
   * Returns this character's defense.
   */
  public int getDef();

  /**
   * Change this character's life.
   */
  public void setLife(Integer life);

  /**
   * Change this character's defense.
   */
  public void setDef(Integer def);
}