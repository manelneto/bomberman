package pt.up.fe.bomberman.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.fe.bomberman.model.elements.Bomberman;
import pt.up.fe.bomberman.model.elements.Powerup;
import pt.up.fe.bomberman.model.elements.powerup.*;

public class PowerupEffectTest {
    private Powerup powerup;
    private Bomberman bomberman;

    @BeforeEach
    void setUP(){
        bomberman = new Bomberman(5,5);
    }

    @Test
    void bombpassTest(){
        powerup = new Bombpass(5,5);
        powerup.applyEffect(bomberman);
        assertTrue(bomberman.canBombpass());
    }

    @Test
    void bombsTest(){
        powerup = new Bombs(5,5);
        powerup.applyEffect(bomberman);
        assertTrue(bomberman.getUsableBombs() == 2);
    }

    @Test
    void detonatorTest(){
        powerup = new Detonator(5,5);
        powerup.applyEffect(bomberman);
        assertTrue(bomberman.canDetonate());
    }

    @Test
    void flamepassTest(){
        powerup = new Flamepass(5,5);
        powerup.applyEffect(bomberman);
        assertTrue(bomberman.canFlamepass());
    }

    @Test
    void flamesTest(){
        powerup = new Flames(5,5);
        powerup.applyEffect(bomberman);
        assertTrue(bomberman.getBombRange() == 2);
    }

    @Test
    void speedTest(){
        powerup = new Speed(5,5);
        powerup.applyEffect(bomberman);
        assertTrue(bomberman.getSpeed() == 2);
    }

    @Test
    void wallpassTest(){
        powerup = new Wallpass(5,5);
        powerup.applyEffect(bomberman);
        assertTrue(bomberman.canWallpass());
    }
}
