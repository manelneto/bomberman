package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Enemy;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {
        switch(enemy.getType()) {
            case 'B': gui.drawBalloom(enemy.getPosition()); break;
            case 'O':gui.drawOneal(enemy.getPosition()); break;
            case 'D':gui.drawDoll(enemy.getPosition()); break;
        }
    }
}
