package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Obstacle;

public class ObstacleViewer implements ElementViewer<Obstacle> {
    @Override
    public void draw(Obstacle obstacle, GUI gui) {
        gui.drawObstacle(obstacle.getPosition());
    }
}
