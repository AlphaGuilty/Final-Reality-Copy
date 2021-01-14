package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.Controller.IController;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Tomas Secul
 */
public class Enemy extends AbstractCharacter implements IEnemy {

  private int weight;
  private int attack;


  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight,
      @NotNull final BlockingQueue<ICharacter> turnsQueue) {
    super(turnsQueue, name, CharacterClass.ENEMY);
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }

  public int getAttack() {return attack;}

  public void setAttack(int attack) {this.attack = attack;}

  public void setWeight(int weight) {this.weight = weight;}

  public void receiveAttack(AbstractPlayerCharacter player){
    if((player.getEquippedWeapon().getDamage()-super.def) > 0){super.life -= (player.getEquippedWeapon().getDamage()-super.def);}
    else{super.life -=1;}
    if(super.life < 0){super.life = 0;}
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
      var enemy = (Enemy) this;
      scheduledExecutor
              .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);

    }


}
