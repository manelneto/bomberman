package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Powerup;
import pt.up.fe.bomberman.model.game.elements.powerup.*;

public class PowerupViewer implements ElementViewer<Powerup> {
    @Override
    public void draw(Powerup powerup, GUI gui) {
        if (powerup instanceof Bombs)
            gui.drawElement(powerup.getPosition(),'e', "#F7EF8A");
        if (powerup instanceof Flames)
            gui.drawElement(powerup.getPosition(),'d', "#F7EF8A");
        if (powerup instanceof Speed)
            gui.drawElement(powerup.getPosition(),'f', "#F7EF8A");
        if (powerup instanceof Wallpass)
            gui.drawElement(powerup.getPosition(),'p', "#F7EF8A");
        if (powerup instanceof Detonator)
            gui.drawElement(powerup.getPosition(),'g', "#F7EF8A");
        if (powerup instanceof Bombpass)
            gui.drawElement(powerup.getPosition(),'r', "#F7EF8A");
        if (powerup instanceof Flamepass)
            gui.drawElement(powerup.getPosition(),'q', "#F7EF8A");
    }
}

