package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.Weapon;

import java.util.List;

/**
 * This represents a character from the game.
 * A character can be controlled by the player.
 *
 * @author Tomas Secul
 */
public interface IPlayerCharacter {
    /**
     * Equips a weapon to the character.
     */
    void equip(Weapon weapon);

    /**
     * Return this character's equipped weapon.
     */
    Weapon getEquippedWeapon();

    /**
     * Returns this character's class.
     */
    CharacterClass getCharacterClass();

    /**
     * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
     * seconds before adding the character to the queue.
     */
    void waitTurn();

    /**
     * This character receives an attack.
     */
    void receiveAttack(Enemy opponent);

    public List<Weapon> ValidWeapon(List<Weapon> list);


}
