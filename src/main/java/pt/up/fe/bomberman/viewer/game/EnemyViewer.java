package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Enemy;
import pt.up.fe.bomberman.model.game.elements.enemy.Balloom;
import pt.up.fe.bomberman.model.game.elements.enemy.Doll;
import pt.up.fe.bomberman.model.game.elements.enemy.Oneal;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {
        if (enemy instanceof Balloom)
            gui.drawElement(enemy.getPosition(), ':', "#FA732C");
        if (enemy instanceof Oneal)
            gui.drawElement(enemy.getPosition(), 'n', "#0000FF");
        if (enemy instanceof Doll)
            gui.drawElement(enemy.getPosition(), 'o', "#FF0000");
        //TBC
    }
}
