package pt.up.fe.bomberman.model.elements.enemy;

import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.elements.Enemy;

public class Oneal extends Enemy {
    public Oneal(int x, int y) {
        super(x, y,3,2,false);
    }

    @Override
    public boolean canMove(Position position) {
        return false;
    }
}
