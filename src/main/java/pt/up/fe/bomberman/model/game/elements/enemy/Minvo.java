package pt.up.fe.bomberman.model.game.elements.enemy;

import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.util.Arrays;

public class Minvo extends Enemy {
    public Minvo(int x, int y) {
        super(x, y,4, Arrays.asList(new Character[]{'U','U', 'R', 'R','D', 'R', 'D','R','L','L'}),false);
    }
}
