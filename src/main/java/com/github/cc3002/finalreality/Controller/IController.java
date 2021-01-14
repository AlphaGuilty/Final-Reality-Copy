package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.weapon.Weapon;

import java.util.List;
/**
 * All methods of the controller.
 *
 * @author Tomas Secul
 */
public interface IController {
    /**
     * Add a teammate to the party.
     */
    void addTeammate(AbstractPlayerCharacter teammate);

    /**
     * Return a character with the characteristic.
     */
    AbstractPlayerCharacter createTeammate(String name, String type, Integer life, Integer def);

    /**
     * Remove a teammate of the party.
     */
    void removeTeammate(AbstractPlayerCharacter teammate);

    /**
     * Return the character with the same name.
     */
    AbstractPlayerCharacter getTeammate(String name);

    /**
     * Add a enemy to the enemies.
     */
    void addEnemy(Enemy opponent);

    /**
     * Return a enemy with the characteristic.
     */
    Enemy createEnemy(String name, Integer weight, Integer atk, Integer life, Integer def);

    /**
     * Remove a enemy of the enemies.
     */
    void removeEnemy(Enemy enemy);

    /**
     * Return the enemy with the same name.
     */
    Enemy getEnemy(String name);

    /**
     * Return a weapon with the characteristic.
     */
    Weapon createWeapon(String name, Integer atk, Integer weight, String type);

    /**
     * Add weapon to the inventory.
     */
    void addWeaponToInventory(Weapon weapon);

    /**
     * Remove weapon to the inventory.
     */
    void removeWeaponToInventory(Weapon weapon);

    /**
     * Return the party.
     */
    List<AbstractPlayerCharacter> seeParty();

    /**
     * Return the enemies.
     */
    List<Enemy> seeEnemies();

    /**
     * Return the inventory.
     */
    List<Weapon> lookInventory();

    /**
     * Return the attack of the character.
     */
    int checkAtk(AbstractPlayerCharacter teammate);

    /**
     * Return the attack of the enemy.
     */
    int checkAtk(Enemy enemy);

    /**
     * Return the defense of the character.
     */
    int checkDef(AbstractPlayerCharacter teammate);

    /**
     * Return the defense of the enemy.
     */
    int checkDef(Enemy enemy);

    /**
     * Return the life of the character.
     */
    int checkLife(AbstractPlayerCharacter teammate);

    /**
     * Return the life of the enemy.
     */
    int checkLife(Enemy enemy);

    /**
     * Return the weapon of the character.
     */
    Weapon checkWeapon(AbstractPlayerCharacter teammate);

    /**
     * Equip the weapon to the character.
     */
    void equipWeaponTo(AbstractPlayerCharacter teammate, Weapon weapon);

    /**
     * Character attacks the enemy.
     */
    void attack(AbstractPlayerCharacter teammate, Enemy enemy);

    /**
     * Enemy attacks the character.
     */
    void attack(Enemy enemy, AbstractPlayerCharacter teammate);

    /**
     * Make preparations to start the fight.
     */
    void buildBattle();

    /**
     * the active character's turn ends.
     */
    void endTurn();

    /**
     * Return true if party won.
     */
    boolean wonParty();

    /**
     * Return true if enemies won.
     */
    boolean wonEnemies();

    /**
     * Return list of valid weapons for the character.
     */
    List<Weapon> ValidWeapon(AbstractPlayerCharacter teammate, List<Weapon> list);
}
