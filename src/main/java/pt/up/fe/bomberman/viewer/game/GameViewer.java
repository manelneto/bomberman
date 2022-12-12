package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Element;
import pt.up.fe.bomberman.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.paintBackground(getModel().getWidth(), getModel().getHeight());
        drawElement(gui, getModel().getBomberman(), new BombermanViewer());
        drawElements(gui, getModel().getBombs(), new BombViewer());
        drawElements(gui, getModel().getEnemies(), new EnemyViewer());
        drawElements(gui, getModel().getExplosions(), new ExplosionViewer());
        drawElements(gui, getModel().getObstacles(), new ObstacleViewer());
        drawElements(gui, getModel().getPowerups(), new PowerupViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
