package pt.up.fe.bomberman.model.arena;

import pt.up.fe.bomberman.model.elements.Bomberman;
import pt.up.fe.bomberman.model.elements.Enemy;
import pt.up.fe.bomberman.model.elements.Obstacle;
import pt.up.fe.bomberman.model.elements.Wall;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setBomberman(createBomberman());
        arena.setEnemies(createEnemies());
        arena.setObstacles(createObstacles());
        arena.setWalls(createWalls());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Obstacle> createObstacles();

    protected abstract List<Enemy> createEnemies();

    protected abstract Bomberman createBomberman();
}

