package pt.up.fe.bomberman.model.elements.enemy;

import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.elements.Enemy;

public class Ovapi extends Enemy {
    public Ovapi(int x, int y) {
        super(x, y,2,2, true);
    }

    @Override
    public boolean canMove(Position position) {
        return false;
    }
}
