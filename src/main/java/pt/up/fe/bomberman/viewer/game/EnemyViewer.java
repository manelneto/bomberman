package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Enemy;


public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {
        if (enemy.getType() == Enemy.Type.Balloom)
            gui.drawElement(enemy.getPosition(), ':', "#FA732C");
        if (enemy.getType() == Enemy.Type.Oneal)
            gui.drawElement(enemy.getPosition(), 'n', "#0000FF");
        if (enemy.getType() == Enemy.Type.Doll)
            gui.drawElement(enemy.getPosition(), 'o', "#FF0000");
        if (enemy.getType() == Enemy.Type.Kondria)
            gui.drawElement(enemy.getPosition(), 'u', "#0000FF");
        if (enemy.getType() == Enemy.Type.Minvo)
            gui.drawElement(enemy.getPosition(), 't', "#FA732C");
        if (enemy.getType() == Enemy.Type.Ovapi)
            gui.drawElement(enemy.getPosition(), 'v', "#FF0000");
        if (enemy.getType() == Enemy.Type.Pass)
            gui.drawElement(enemy.getPosition(), 'w', "#FA732C");
        if (enemy.getType() == Enemy.Type.Pontan)
            gui.drawElement(enemy.getPosition(), 'x', "#FF0000");
        //TBC
    }
}
