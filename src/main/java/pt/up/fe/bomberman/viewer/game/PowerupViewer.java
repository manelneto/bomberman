package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Powerup;

public class PowerupViewer implements ElementViewer<Powerup> {
    @Override
    public void draw(Powerup powerup, GUI gui) {
        switch (powerup.getEffect()){

            case Bombpass:{gui.drawPowerupBombpass(powerup.getPosition());break;}

            case Bombs:{gui.drawPowerupBombs(powerup.getPosition());break;}

            case Detonator:{gui.drawPowerupDetonator(powerup.getPosition());break;}

            case Flamepass:{gui.drawPowerupFlamepass(powerup.getPosition());break;}

            case Flames:{gui.drawPowerupFlames(powerup.getPosition());break;}

            case Speed:{gui.drawPowerupSpeed(powerup.getPosition());break;}

            case Wallpass:{gui.drawPowerupWallpass(powerup.getPosition());break;}


        }
    }
}

