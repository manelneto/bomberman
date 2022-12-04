package pt.up.fe.bomberman.model.elements.enemy;

import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.elements.Enemy;

public class Pontan extends Enemy {
    public Pontan(int x, int y) {
        super(x, y,4,3,true);
    }

    @Override
    public boolean canMove(Position position) {
        return false;
    }

}
