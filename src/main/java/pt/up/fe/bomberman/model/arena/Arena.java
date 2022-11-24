package pt.up.fe.bomberman.model.arena;

import pt.up.fe.bomberman.model.elements.Bomberman;
import pt.up.fe.bomberman.model.elements.Enemy;
import pt.up.fe.bomberman.model.elements.Obstacle;
import pt.up.fe.bomberman.model.elements.Wall;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Bomberman bomberman;
    private List<Enemy> enemies;
    private List<Obstacle> obstacles;
    private List<Wall> walls;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Bomberman getBomberman() {
        return bomberman;
    }

    public void setBomberman(Bomberman bomberman) {
        this.bomberman = bomberman;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }
}

