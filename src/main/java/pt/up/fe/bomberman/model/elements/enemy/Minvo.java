package pt.up.fe.bomberman.model.elements.enemy;

import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.elements.Enemy;

public class Minvo extends Enemy {
    public Minvo(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMove(Position position) {
        return false;
    }

    private final int speed = 4;
    private final int smart = 2;
    private final boolean wallpass = false;

}
