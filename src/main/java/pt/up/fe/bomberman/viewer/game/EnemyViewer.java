package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Enemy;


public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {
        if (enemy.getType() == Enemy.enemyType.Balloom)
            gui.drawElement(enemy.getPosition(), ':', "#FA732C");
        if (enemy.getType() == Enemy.enemyType.Oneal)
            gui.drawElement(enemy.getPosition(), 'n', "#0000FF");
        if (enemy.getType() == Enemy.enemyType.Doll)
            gui.drawElement(enemy.getPosition(), 'o', "#FF0000");
        if (enemy.getType() == Enemy.enemyType.Kondria)
            gui.drawElement(enemy.getPosition(), 'u', "#0000FF");
        if (enemy.getType() == Enemy.enemyType.Minvo)
            gui.drawElement(enemy.getPosition(), 't', "#FA732C");
        if (enemy.getType() == Enemy.enemyType.Ovapi)
            gui.drawElement(enemy.getPosition(), 'v', "#FF0000");
        if (enemy.getType() == Enemy.enemyType.Pass)
            gui.drawElement(enemy.getPosition(), 'w', "#FA732C");
        if (enemy.getType() == Enemy.enemyType.Pontan)
            gui.drawElement(enemy.getPosition(), 'x', "#FF0000");
        //TBC
    }
}
