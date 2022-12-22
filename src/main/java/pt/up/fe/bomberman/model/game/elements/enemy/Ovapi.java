package pt.up.fe.bomberman.model.game.elements.enemy;

import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.util.Arrays;

public class Ovapi extends Enemy {
    public Ovapi(int x, int y) {
        super(x, y,2, Arrays.asList(new Character[]{'U','U','U','U', 'R', 'R','D','D','D', 'R', 'D','R','L','L'}), true);
    }
}
