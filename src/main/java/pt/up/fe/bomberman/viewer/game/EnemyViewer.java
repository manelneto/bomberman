package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Enemy;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {
        switch(enemy.getType()) {
            case 'B': gui.drawElement(enemy.getPosition(), ':', "#FA732C"); break;
            case 'O':gui.drawElement(enemy.getPosition(), 'n', "#0000FF"); break;
            case 'D':gui.drawElement(enemy.getPosition(), 'o', "#FF0000"); break;
        }
    }
}
