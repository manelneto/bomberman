package pt.up.fe.bomberman.model.arena;

import pt.up.fe.bomberman.model.elements.Bomberman;
import pt.up.fe.bomberman.model.elements.Enemy;
import pt.up.fe.bomberman.model.elements.Obstacle;
import pt.up.fe.bomberman.model.elements.Wall;

import java.util.ArrayList;
import java.util.List;

public abstract class ArenaBuilder {
    private final int width = 20;
    private final int height = 20;

    public Arena createArena() {
        Arena arena = new Arena(width, height);

        arena.setBomberman(createBomberman());
        arena.setEnemies(createEnemies());
        arena.setObstacles(createObstacles());
        arena.setWalls(createWalls());

        return arena;
    }

    protected Bomberman createBomberman() {
        return new Bomberman(1, 1);
    }

    protected List<Enemy> createEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(5, 5));
        return enemies;
    }

    protected List<Obstacle> createObstacles() {
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Obstacle(10, 10));
        return obstacles;
    }

    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(15, 15));
        return walls;
    }

}
