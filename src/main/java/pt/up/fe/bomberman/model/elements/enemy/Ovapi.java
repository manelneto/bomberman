package pt.up.fe.bomberman.model.elements.enemy;

import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.elements.Enemy;

public class Ovapi extends Enemy {
    public Ovapi(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMove(Position position) {
        return false;
    }

    private final int speed = 2;
    private final int smart = 2;
    private final boolean wallpass = true;
}
