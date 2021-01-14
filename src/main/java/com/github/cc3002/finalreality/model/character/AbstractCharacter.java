package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.Controller.Data;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Tomas Secul
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  protected final CharacterClass characterClass;
  protected Weapon equippedWeapon = null;
  protected ScheduledExecutorService scheduledExecutor;
  protected Integer life;
  protected Integer def;
  protected Data data;


  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, CharacterClass characterClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
  }



  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    data.send();
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  public int getLife() {return life;}

  public int getDef() {return def;}

  public void setLife(Integer life) {this.life = life;}

  public void setDef(Integer def) {this.def = def;}

  public void setData(Data data) {this.data = data;}

  public CharacterClass getCharacterClass() {
    return characterClass;
  }
}

