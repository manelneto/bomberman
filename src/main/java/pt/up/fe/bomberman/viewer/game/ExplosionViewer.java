package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Explosion;

public class ExplosionViewer implements ElementViewer<Explosion>{

    @Override
    public void draw(Explosion explosion, GUI gui) {

        if (explosion.getType()=='H')gui.drawExplosionHorizontal(explosion.getPosition());
        else    gui.drawExplosionVertical(explosion.getPosition());

    }
}
