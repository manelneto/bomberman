package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Explosion;
import pt.up.fe.bomberman.model.game.elements.ExplosionHorizontal;
import pt.up.fe.bomberman.model.game.elements.ExplosionVertical;

public class ExplosionViewer implements ElementViewer<Explosion>{

    @Override
    public void draw(Explosion explosion, GUI gui) {
        ExplosionHorizontal ex= new ExplosionHorizontal(0,0,1);
        if (explosion==ex)gui.drawExplosionHorizontal(explosion.getPosition());
            gui.drawExplosionVertical(explosion.getPosition());

    }
}
