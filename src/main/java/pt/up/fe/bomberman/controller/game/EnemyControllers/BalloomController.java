package pt.up.fe.bomberman.controller.game.EnemyControllers;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.game.EnemyController;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.io.IOException;

public class BalloomController extends EnemyController {



        public BalloomController(Arena arena) {
            super(arena);

            this.lastMovementTime = 0;
        }
        @Override
        public void step(Game game, GUI.ACTION action, long time) throws IOException {
            if (time - lastMovementTime > 350){
                for (Enemy monster : getModel().getEnemies())
                    if(monster.getType()=='B')
                        moveEnemy(monster,monster.getmovePatern());

                this.lastMovementTime = time;
            }
            
        }

    private Position movePatern(Enemy monster){
        if(monster.getDirection()=='D')
            return monster.getPosition().getDown();
        if(monster.getDirection()=='U')
            return monster.getPosition().getUp();
        if(monster.getDirection()=='R')
            return monster.getPosition().getRight();
        if(monster.getDirection()=='L')
            return monster.getPosition().getLeft();
        return monster.getPosition().getDown();
    }
    


    private void moveBalloom(Enemy monster) {
        Position position =movePatern(monster);

        if (!getModel().isWall(position) && !getModel().isObstacle(position) && !getModel().isEnemy(position) && !getModel().isBomb(position)) {
            monster.setPosition(position);
            if (getModel().getBomberman().getPosition().equals(position))
                getModel().getBomberman().decreaseHp();
        }
        
    }
}
