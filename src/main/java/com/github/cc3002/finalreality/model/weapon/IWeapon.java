package com.github.cc3002.finalreality.model.weapon;

/**
 * This interface represents all weapons in the game.
 * The signature for all the common methods of the weapons are defined here.
 * @author Tomas Secul
 */

public interface IWeapon {
    /**
     * @return the name of the item
     */
    String getName();


    /**
     * @return the damage of the item
     */
    int getDamage();


    /**
     * @return the weight of the item
     */
    int getWeight();


    /**
     * @return the type of the item
     */
    WeaponType getType();


    /**
     * @return if it is the same object
     */
    @Override
    boolean equals(Object o);


    /**
     * Generates a hash code for a sequence of input values. The hash code is generated as if all the input values were placed into an array
     */
    @Override
    int hashCode();
}
