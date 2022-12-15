package pt.up.fe.bomberman.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.fe.bomberman.controller.game.BombermanController;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.*;
import pt.up.fe.bomberman.model.game.elements.powerup.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerupEffectTest {
    private Powerup powerup;
    private Bomberman bomberman;
    private BombermanController bcontroller;
    private Arena arena;

    @BeforeEach
    void setUP(){
        bomberman = new Bomberman(4,5);
        arena = new Arena(40,20);
        arena.setBomberman(bomberman);
        arena.setObstacles(new ArrayList<Obstacle>());
        arena.setWalls(new ArrayList<Wall>());
        arena.setEnemies(new ArrayList<Enemy>());
        bcontroller = new BombermanController(arena);
    }


    @Test
    void bombpassTest(){
        powerup = new Bombpass(5,5);
        List<Powerup> powerups = new ArrayList<Powerup>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        bcontroller.moveBombermanRight();
        assertTrue(bomberman.canBombpass());
    }

    @Test
    void bombsTest(){
        powerup = new Bombs(5,5);
        List<Powerup> powerups = new ArrayList<Powerup>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        bcontroller.moveBombermanRight();
        assertTrue(bomberman.getBombs() == 2);
    }

    @Test
    void healthTest(){
        powerup = new Health(5,5);
        List<Powerup> powerups = new ArrayList<Powerup>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        bcontroller.moveBombermanRight();
        assertTrue(bomberman.getHp() == 2);
    }

    @Test
    void flamepassTest(){
        powerup = new Flamepass(5,5);
        List<Powerup> powerups = new ArrayList<Powerup>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        bcontroller.moveBombermanRight();
        assertTrue(bomberman.canFlamepass());
    }

    @Test
    void flamesTest(){
        powerup = new Flames(5,5);
        List<Powerup> powerups = new ArrayList<Powerup>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        bcontroller.moveBombermanRight();
        assertTrue(bomberman.getFlames() == 2);
    }

    @Test
    void speedTest(){
        powerup = new Speed(5,5);
        List<Powerup> powerups = new ArrayList<Powerup>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        bcontroller.moveBombermanRight();
        assertTrue(bomberman.getSpeed() == 2);
    }

    @Test
    void wallpassTest(){
        powerup = new Wallpass(5,5);
        List<Powerup> powerups = new ArrayList<Powerup>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        bcontroller.moveBombermanRight();
        assertTrue(bomberman.canWallpass());
    }
}

