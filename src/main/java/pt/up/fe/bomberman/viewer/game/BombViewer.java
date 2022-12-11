package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Bomb;

public class BombViewer implements ElementViewer<Bomb>  {

    @Override
    public void draw(Bomb bomb, GUI gui) {
        gui.drawBomb(bomb.getPosition());
    }
}
