package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Enemy;
import pt.up.fe.bomberman.model.game.elements.enemy.*;


public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {
        if (enemy instanceof Balloom)
            gui.drawElement(enemy.getPosition(), ':', "#FA732C");
        if (enemy instanceof Oneal)
            gui.drawElement(enemy.getPosition(), 'n', "#0000FF");
        if (enemy instanceof Doll)
            gui.drawElement(enemy.getPosition(), 'o', "#FF0000");
        if (enemy instanceof Kondria)
            gui.drawElement(enemy.getPosition(), 'u', "#0000FF");
        if (enemy instanceof Minvo)
            gui.drawElement(enemy.getPosition(), 't', "#FA732C");
        if (enemy instanceof Ovapi)
            gui.drawElement(enemy.getPosition(), 'v', "#FF0000");
        if (enemy instanceof Pass)
            gui.drawElement(enemy.getPosition(), 'w', "#FA732C");
        if (enemy instanceof Pontan)
            gui.drawElement(enemy.getPosition(), 'x', "#FF0000");
        //TBC
    }
}
