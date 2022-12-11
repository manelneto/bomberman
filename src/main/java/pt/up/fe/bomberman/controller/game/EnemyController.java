
package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.io.IOException;

public class EnemyController extends GameController {
    private long lastMovementTime;

    public EnemyController(Arena arena) {
        super(arena);

        this.lastMovementTime = 0;
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovementTime > 350) {
            for (Enemy monster : getModel().getEnemies())
                moveEnemy(monster, monster.getPosition().getRandomNeighbour());
            this.lastMovementTime = time;
        }
    }

    private void moveEnemy(Enemy monster, Position position) {
        if (!getModel().isWall(position) && !getModel().isObstacle(position) && !getModel().isEnemy(position) && !getModel().isBomb(position)) {
            monster.setPosition(position);
            if (getModel().getBomberman().getPosition().equals(position))
                getModel().getBomberman().decreaseHp();
        }
    }
}

