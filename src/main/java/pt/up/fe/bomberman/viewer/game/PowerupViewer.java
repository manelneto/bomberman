package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Powerup;

public class PowerupViewer implements ElementViewer<Powerup> {
    @Override
    public void draw(Powerup powerup, GUI gui) {
        if (powerup.getType()== Powerup.powerupType.Bombs)
            gui.drawElement(powerup.getPosition(),'e', "#F7EF8A");
        if (powerup.getType()== Powerup.powerupType.Flames)
            gui.drawElement(powerup.getPosition(),'d', "#F7EF8A");
        if (powerup.getType()== Powerup.powerupType.Speed)
            gui.drawElement(powerup.getPosition(),'f', "#F7EF8A");
        if (powerup.getType()== Powerup.powerupType.Wallpass)
            gui.drawElement(powerup.getPosition(),'p', "#F7EF8A");
        if (powerup.getType()== Powerup.powerupType.Health)
            gui.drawElement(powerup.getPosition(),'g', "#F7EF8A");
        if (powerup.getType()== Powerup.powerupType.Bombpass)
            gui.drawElement(powerup.getPosition(),'r', "#F7EF8A");
        if (powerup.getType()== Powerup.powerupType.Flamepass)
            gui.drawElement(powerup.getPosition(),'q', "#F7EF8A");
    }
}

