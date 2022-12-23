package pt.up.fe.bomberman.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.fe.bomberman.controller.game.BombermanController;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerupEffectTest {
    private BombermanController controller;
    private Bomberman bomberman;
    private Powerup powerup;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        bomberman = new Bomberman(4, 5);
        arena.setBomberman(bomberman);
        controller = new BombermanController(arena);
    }

    @Test
    void bombs() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.BOMBS);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertEquals(2, bomberman.getBombs());
    }

    @Test
    void flames() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.FLAMES);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertEquals(2, bomberman.getFlames());
    }

    @Test
    void speed() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.SPEED);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertEquals(2, bomberman.getSpeed());
    }

    @Test
    void wallpass() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.WALLPASS);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertTrue(bomberman.canWallpass());
    }

    @Test
    void health() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.HEALTH);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertEquals(2, bomberman.getHp());
    }

    @Test
    void bombpass() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.BOMBPASS);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertTrue(bomberman.canBombpass());
    }

    @Test
    void flamepass() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.FLAMEPASS);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertTrue(bomberman.canFlamepass());
    }
}
