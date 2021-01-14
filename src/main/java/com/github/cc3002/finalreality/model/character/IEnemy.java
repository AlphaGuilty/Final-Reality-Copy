package com.github.cc3002.finalreality.model.character;

/**
 * This represents a Enemy from the game.
 * A character can be controlled by the CPU.
 *
 * @author Tomas Secul
 */

public interface IEnemy {

    /**
     * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
     * seconds before adding the character to the queue.
     */
    void waitTurn();

    /**
     * Returns the weight of this enemy.
     */
    int getWeight();

    /**
     * Returns the attack of this enemy.
     */
    int getAttack();

    /**
     * Change the attack of this enemy.
     */
    void setAttack(int attack);

    /**
     * This enemy receives an attack.
     */
    void receiveAttack(AbstractPlayerCharacter player);
}
