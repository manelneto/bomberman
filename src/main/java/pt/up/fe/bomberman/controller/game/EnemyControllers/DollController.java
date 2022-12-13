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
        if (time - lastMovementTime > 250) {
            for (Enemy monster : getModel().getEnemies())
                if(monster.getType()=='D')
                    moveEnemy(monster,getmovePatern(monster));

            this.lastMovementTime = time;
        }
    }
    protected Position getmovePatern(Enemy monster){
        switch (monster.getDirection()){
            case('D'): if(canmoveto(monster,monster.getPosition().getRight())) {
                monster.setDirection('R');
                return monster.getPosition().getRight();
            }

            case('R'): if(canmoveto(monster,monster.getPosition().getUp())) {
                monster.setDirection('U');
                return monster.getPosition().getUp();
            }

            case('U'): if(canmoveto(monster,monster.getPosition().getLeft())) {
                monster.setDirection('L');
                return monster.getPosition().getLeft();
            }

            case('L'): if(canmoveto(monster,monster.getPosition().getDown())) {
                monster.setDirection('D');
                return monster.getPosition().getDown();
            }

        }
        monster.setDirection('D');
        return monster.getPosition().getDown();
    }


}
