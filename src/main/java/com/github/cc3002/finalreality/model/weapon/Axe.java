package com.github.cc3002.finalreality.model.weapon;


/**
 *  * A class that holds all the information of a axe.
 * @author Tomas Secul.
 */

public class Axe extends Weapon {

    public Axe(final String name, final int damage, final int weight) {
        super(name, damage, weight, WeaponType.AXE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Axe)) {
            return false;
        }
        final Axe weapon = (Axe) o;
        return getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());
    }

}