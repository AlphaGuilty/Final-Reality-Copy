package com.github.cc3002.finalreality.model.weapon;


/**
 * A class that holds all the information of a Staff.
 * @author Tomas Secul.
 */

public class Staff extends Weapon {

    public Staff(final String name, final int damage, final int weight){
        super(name, damage, weight, WeaponType.STAFF);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Staff)) {
            return false;
        }
        final Staff weapon = (Staff) o;
        return getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());
    }
}