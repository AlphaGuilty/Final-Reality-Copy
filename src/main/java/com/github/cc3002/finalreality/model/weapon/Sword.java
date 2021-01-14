package com.github.cc3002.finalreality.model.weapon;


/**
 * A class that holds all the information of a Sword.
 * @author Tomas Secul.
 */

public class Sword extends Weapon {

    public Sword(final String name, final int damage, final int weight){
        super(name, damage, weight, WeaponType.SWORD);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sword)) {
            return false;
        }
        final Sword weapon = (Sword) o;
        return getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());
    }
}