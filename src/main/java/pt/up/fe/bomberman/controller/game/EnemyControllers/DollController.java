package pt.up.fe.bomberman.controller.game.EnemyControllers;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.game.EnemyController;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.io.IOException;

public class DollController extends EnemyController {


    public DollController(Arena arena) {
        super(arena);

        this.lastMovementTime = 0;
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovementTime > 450) {
            for (Enemy monster : getModel().getEnemies())
                if(monster.getType()=='D')
                    moveEnemy(monster,monster.getmovePatern());

            this.lastMovementTime = time;
        }
    }



}
