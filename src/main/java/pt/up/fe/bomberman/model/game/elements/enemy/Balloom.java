package pt.up.fe.bomberman.model.game.elements.enemy;

import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.elements.Enemy;

public class Balloom extends Enemy {
    public Balloom(int x, int y) {
        super(x, y,2,1,false);
    }
    @Override
    public char getType() {
        return 'B';
    }


    @Override
    public Position movePatern(){
        if(getDirection()=='D')
            return getPosition().getDown();
        if(getDirection()=='U')
            return getPosition().getUp();
        if(getDirection()=='R')
            return getPosition().getRight();
        if(getDirection()=='L')
            return getPosition().getLeft();
        return getPosition().getDown();
    }
}
