
package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.game.EnemyControllers.BalloomController;
import pt.up.fe.bomberman.controller.game.EnemyControllers.DollController;
import pt.up.fe.bomberman.controller.game.EnemyControllers.OnealController;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.menu.Menu;
import pt.up.fe.bomberman.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {

    private final BombermanController bombermanController;
    private final BombController bombController;
    private final EnemyController balloomController;
    private final EnemyController onealController;
    private final EnemyController dollController;

    private final FlameController flameController;

    public ArenaController(Arena arena) {
        super(arena);

        this.flameController = new FlameController(arena);
        this.bombController= new BombController(arena);
        this.bombermanController = new BombermanController(arena);
        this.balloomController = new BalloomController(arena) ;
        this.onealController = new OnealController(arena) ;
        this.dollController = new DollController(arena) ;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getBomberman().getHp() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            bombermanController.step(game, action, time);
            balloomController.step(game, action, time);
            onealController.step(game, action, time);
            dollController.step(game, action, time);
            bombController.step(game,action,time);
            flameController.step(game,action,time);
        }
    }
}

