package com.github.cc3002.finalreality.model.weapon;


/**
 * A class that holds all the information of a bow.
 * @author Tomas Secul.
 */

public class Bow extends Weapon {

    public Bow(final String name, final int damage, final int weight) {
        super(name, damage, weight, WeaponType.BOW);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bow)) {
            return false;
        }
        final Bow weapon = (Bow) o;
        return getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());
    }
}