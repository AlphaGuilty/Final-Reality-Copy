package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 *  * A class that holds all the information of Enemies.
 * @author Tomas Secul.
 */


public class EnemyTeam implements IEnemyTeam {
    private final List<Enemy> eTeam = new ArrayList<>();
    protected BlockingQueue<ICharacter> turns;

    public EnemyTeam(BlockingQueue<ICharacter> turns) {
        this.turns = turns;
    }

    @Override
    public List<Enemy> getTeam() {
        return eTeam;
    }

    @Override
    public void addTeammate(Enemy opponent){
        eTeam.add(opponent);
    }

    @Override
    public void removeTeammate(Enemy opponent){
        eTeam.remove(opponent);
    }

    @Override
    public Enemy getOpponent(String name){
        for (Enemy opponent : eTeam){
            if(name.equals(opponent.getName())){return opponent;}
        }
        return null;
    }

    @Override
    public int checkLife(Enemy opponent){
        return opponent.getLife();
    }

    @Override
    public int checkDef(Enemy opponent){
        return opponent.getDef();
    }

    @Override
    public int checkAtk(Enemy opponent){
        return opponent.getAttack();
    }

    @Override
    public boolean isInTeam(String name){
        if(name==null){return false;}
        for (Enemy opponent : eTeam){
            if(name.equals(opponent.getName())){
                return true;
            }
        }
        return false;
    }

}
