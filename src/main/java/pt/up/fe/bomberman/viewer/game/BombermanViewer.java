package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.elements.Bomberman;

public class BombermanViewer implements ElementViewer<Bomberman> {

    @Override
    public void draw(Bomberman bomberman, GUI gui) {
        gui.drawBomberman(bomberman.getPosition());
    }
}

