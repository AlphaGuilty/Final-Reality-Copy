package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;

import java.util.List;
/**
 * All methods of the party.
 *
 * @author Tomas Secul
 */
public interface IPartyTeam {
    /**
     * Return the party.
     */
    List<AbstractPlayerCharacter> getTeam();

    /**
     * Add a teammate to the party.
     */
    void addTeammate(AbstractPlayerCharacter teammate);

    /**
     * Remove a teammate of the party.
     */
    void removeTeammate(AbstractPlayerCharacter teammate);

    /**
     * Return the character with the same name.
     */
    AbstractPlayerCharacter getTeammate(String name);

    /**
     * Equip the weapon to the character.
     */
    void equipWeaponTo(AbstractPlayerCharacter teammate, Weapon weapon);

    /**
     * Return the life of the character.
     */
    int checkLife(AbstractPlayerCharacter teammate);

    /**
     * Return the defense of the character.
     */
    int checkDef(AbstractPlayerCharacter teammate);

    /**
     * Return the attack of the character.
     */
    int checkAtk(AbstractPlayerCharacter teammate);

    /**
     * Return the weapon of the character.
     */
    Weapon checkWeapon(AbstractPlayerCharacter teammate);

    /**
     * Return the inventory.
     */
    List<Weapon> getInventoryWeapons();

    /**
     * Add weapon to the inventory.
     */
    void addWeaponToInventory(Weapon weapon);

    /**
     * Remove weapon to the inventory.
     */
    void removeWeaponToInventory(Weapon weapon);

    /**
     * Return a character with the characteristic.
     */
    AbstractPlayerCharacter createTeammate(String name, Integer life, Integer def, String type);

    /**
     * returns true if there is a character with the name.
     */
    boolean isInTeam(String name);
}
