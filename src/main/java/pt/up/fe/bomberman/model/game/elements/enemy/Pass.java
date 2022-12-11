package pt.up.fe.bomberman.model.game.elements.enemy;

import pt.up.fe.bomberman.model.game.elements.Enemy;

public class Pass extends Enemy {
    public Pass(int x, int y) {
        super(x, y,4,3,false);
    }

    @Override
    public char getType() {
        return 'P';
    }
}
