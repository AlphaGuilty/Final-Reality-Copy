package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter {
    protected AbstractPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name, CharacterClass characterClass) {
        super(turnsQueue, name, characterClass);
    }

    @Override
    public void equip(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    @Override
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }


    public void receiveAttack(Enemy opponent){
        if((opponent.getAttack()-this.def) > 0){this.life -= (opponent.getAttack()-this.def);}
        else{this.life -=1;}
        if(this.life < 0){this.life = 0;}
    }


    public void waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            scheduledExecutor
                    .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);


    }

    public void addToList(Weapon e, List<Weapon> list) {
        return;
    }

}