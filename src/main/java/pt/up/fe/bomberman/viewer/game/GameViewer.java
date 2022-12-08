package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Element;
import pt.up.fe.bomberman.model.game.elements.Explosion;
import pt.up.fe.bomberman.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.paintBackground(getModel().getWidth(), getModel().getHeight());
        if(getModel().HasBomb()) drawElement(gui, getModel().getBomb() , new BombViewer());
        if(!getModel().getExplosion().isEmpty()) drawElements(gui, getModel().getExplosion() , new ExplosionViewer());
        drawElement(gui, getModel().getBomberman(), new BombermanViewer());
        drawElements(gui, getModel().getEnemies(), new EnemyViewer());
        drawElements(gui, getModel().getObstacles(), new ObstacleViewer());
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
