package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Explosion;

public class ExplosionViewer implements ElementViewer<Explosion>{

    @Override
    public void draw(Explosion explosion, GUI gui) {
        if (explosion.getType() == 'H')
            gui.drawElement(explosion.getPosition(),'a', "#FF4500");
        else
            gui.drawElement(explosion.getPosition(),'b', "#FF4500");
    }
}
