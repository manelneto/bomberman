package pt.up.fe.bomberman.model.game.arena;


import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.*;
import pt.up.fe.bomberman.model.game.elements.enemy.Balloom;
import pt.up.fe.bomberman.model.game.elements.powerup.Bombpass;


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
        arena.setPowerups(createPower());
        arena.setWalls(createWalls());

        return arena;
    }

    protected Bomberman createBomberman() {
        return new Bomberman(1, 1);
    }

    protected List<Enemy> createEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Balloom(5, 5));
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
    protected List<Powerup> createPower() {
        List<Powerup> powerup = new ArrayList<>();

        powerup.add(new Bombpass(20,20));

        return powerup;
    }

}