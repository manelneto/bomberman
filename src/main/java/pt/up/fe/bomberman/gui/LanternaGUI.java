package pt.up.fe.bomberman.gui;

import com.googlecode.lanterna.screen.Screen;
import pt.up.fe.bomberman.model.Position;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    @Override
    public ACTION getNextAction() {
        return null;
    }

    @Override
    public void drawBomberman(Position position) {

    }

    @Override
    public void drawObstacle(Position position) {

    }

    @Override
    public void drawWall(Position position) {

    }

    @Override
    public void drawEnemy(Position position) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void close() {

    }
}
