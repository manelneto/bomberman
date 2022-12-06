package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.arena.Arena;
import pt.up.fe.bomberman.model.elements.Enemy;
import pt.up.fe.bomberman.model.menu.Menu;
import pt.up.fe.bomberman.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {

    private final BombermanController bombermanController;
    private final EnemyController enemyController;

    public ArenaController(Arena arena) {
        super(arena);

        this.bombermanController = new BombermanController(arena);
        this.enemyController = new EnemyController(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getBomberman().getHp() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            bombermanController.step(game, action, time);
            enemyController.step(game, action, time);
        }
    }
}
