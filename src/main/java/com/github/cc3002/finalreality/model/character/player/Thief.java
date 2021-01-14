package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds the information of Thief.
 * @author Tomas Secul
 */
public class Thief extends AbstractPlayerCharacter {

    /**
     * Creates a new character.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     */
    public Thief(@NotNull String name,
                 @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(turnsQueue, name, CharacterClass.THIEF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Thief)) {
            return false;
        }
        final Thief that = (Thief) o;
        return getName().equals(that.getName());
    }

    @Override
    public void equip(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    @Override
    public List<Weapon> ValidWeapon(List<Weapon> list) {
        List<Weapon> res = new ArrayList<>();
        for(Weapon e : list){
            switch (e.getType()) {
                case AXE:
                    Axe w1 = (Axe) e;
                    addToList(w1, res);
                    break;
                case BOW:
                    Bow w2 = (Bow) e;
                    addToList(w2, res);
                    break;
                case KNIFE:
                    Knife w3 = (Knife) e;
                    addToList(w3, res);
                    break;
                case STAFF:
                    Staff w4 = (Staff) e;
                    addToList(w4, res);
                    break;
                case SWORD:
                    Sword w5 = (Sword) e;
                    addToList(w5, res);
                    break;
                default:
                    addToList(e, res);
                    break;
            }
        }
        return res;
    }

    private void addToList(Knife w, List<Weapon> res) {
        res.add(w);
    }

    private void addToList(Bow w, List<Weapon> res) {
        res.add(w);
    }

    private void addToList(Sword w, List<Weapon> res) {
        res.add(w);
    }

}
