package pt.up.fe.bomberman.model.game.elements.enemy;

import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.util.Arrays;

public class Oneal extends Enemy {
    public Oneal(int x, int y) {
        super(x, y,3, Arrays.asList(new Character[]{'U','U', 'R', 'R','D', 'R', 'D','R','L','L'}),false);
    }
}
