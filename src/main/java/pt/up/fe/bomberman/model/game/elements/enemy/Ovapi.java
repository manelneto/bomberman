package pt.up.fe.bomberman.model.game.elements.enemy;

import pt.up.fe.bomberman.model.game.elements.Enemy;

public class Ovapi extends Enemy {
    public Ovapi(int x, int y) {
        super(x, y,2,2, true);
    }

    @Override
    public char getType() {
        return 'V';
    }
}
