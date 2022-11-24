package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.elements.Powerup;

public class PowerupViewer implements ElementViewer<Powerup> {
    @Override
    public void draw(Powerup element, GUI gui) {
        gui.drawPowerup(element.getPosition());
    }
}
