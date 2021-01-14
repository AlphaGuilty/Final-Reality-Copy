package com.github.cc3002.finalreality.model.weapon;


/**
 *  A class that holds all the information of a Knife.
 * @author Tomas Secul.
 */

public class Knife extends Weapon {

    public Knife(final String name, final int damage, final int weight){
        super(name, damage, weight, WeaponType.KNIFE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Knife)) {
            return false;
        }
        final Knife weapon = (Knife) o;
        return getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());
    }
}