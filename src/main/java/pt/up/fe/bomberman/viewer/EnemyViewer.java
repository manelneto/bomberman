package pt.up.fe.bomberman.viewer;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.elements.Enemy;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy element, GUI gui) {
        gui.drawEnemy(element.getPosition());
    }
}
