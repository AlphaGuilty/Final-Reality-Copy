package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.Enemy;

import java.util.List;

public interface IEnemyTeam {
    /**
     * Return the enemies.
     */
    List<Enemy> getTeam();

    /**
     * Add a enemy to the enemies.
     */
    void addTeammate(Enemy opponent);

    /**
     * Remove a enemy of the enemies.
     */
    void removeTeammate(Enemy opponent);

    /**
     * Return the enemy with the same name.
     */
    Enemy getOpponent(String name);

    /**
     * Return the life of the enemy.
     */
    int checkLife(Enemy opponent);

    /**
     * Return the defense of the enemy.
     */
    int checkDef(Enemy opponent);

    /**
     * Return the attack of the enemy.
     */
    int checkAtk(Enemy opponent);

    /**
     * returns true if there is a enemy with the name.
     */
    boolean isInTeam(String name);
}
