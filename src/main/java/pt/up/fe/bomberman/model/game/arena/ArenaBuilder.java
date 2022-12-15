package pt.up.fe.bomberman.model.game.arena;

import pt.up.fe.bomberman.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder {
    private final int width = 20;
    private final int height = 20;

    public Arena createArena() {
        Arena arena = new Arena(width, height);

        arena.setBomberman(createBomberman());
        arena.setObstacles(createObstacles());
        arena.setWalls(createWalls());
        arena.setEnemies(createEnemies());
        arena.setPowerups(createPowerups());

        return arena;
    }

    protected abstract Bomberman createBomberman();
    protected abstract List<Obstacle> createObstacles();
    protected abstract List<Wall> createWalls();
    protected abstract List<Enemy> createEnemies();
    protected abstract List<Powerup> createPowerups();
}
