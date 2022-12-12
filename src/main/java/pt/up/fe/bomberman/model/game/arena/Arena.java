package pt.up.fe.bomberman.model.game.arena;

import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Bomberman bomberman;
    private List<Bomb> bombs = new ArrayList<>();
    private List<Explosion> explosions = new ArrayList<>();
    private List<Enemy> enemies;
    private List<Obstacle> obstacles;
    private List<Wall> walls;

    private List<Powerup> powerups = new ArrayList<>(); //no powerups for now


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

    public List<Bomb> getBombs() {
        return bombs;
    }

    public List<Explosion> getExplosions() {
        return explosions;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Powerup> getPowerups() {
        return powerups;
    }

    public void setBomberman(Bomberman bomberman) {
        this.bomberman = bomberman;
    }

    public void setBombs(List<Bomb> bombs) {
        this.bombs = bombs;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void setExplosions(List<Explosion> explosions) {
        this.explosions = explosions;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setPowerups(List<Powerup> powerups) {
        this.powerups = powerups;
    }

    public void createBomb(long time) {
        Bomb bomb = new Bomb(bomberman.getPosition().getX(), bomberman.getPosition().getY(), time, getBomberman().getBombRange());
        bombs.add(bomb);
    }

    public boolean isBomb(Position position) {
        for (Bomb bomb : bombs)
            if (bomb.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isEnemy(Position position) {
        for (Enemy enemy : enemies)
            if (enemy.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isObstacle(Position position) {
        for (Obstacle obstacle : obstacles)
            if (obstacle.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isPowerup(Position position) {
        for (Powerup powerup : powerups)
            if (powerup.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isWall(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return true;
        return false;
    }

    public Powerup findPowerup(Position position) {
        for (Powerup powerup : powerups)
            if (powerup.getPosition().equals(position))
                return powerup;
        return null;
    }

    public void explodeBomb(Bomb bomb, long time) {
        explosions.add(new Explosion(bomb.getPosition().getX(), bomb.getPosition().getY(), time, 'H'));
        for (int up = 1; up <= bomb.getExplosionRadius() && !isWall(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() - up)); up++) {
            explosions.add(new Explosion(bomb.getPosition().getX(), bomb.getPosition().getY() - up, time, 'V'));
            if (isObstacle(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() - up))) {
                break;
            }
        }
        for (int down = 1; down <= bomb.getExplosionRadius() && !isWall(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() + down)); down++) {
            explosions.add(new Explosion(bomb.getPosition().getX(), bomb.getPosition().getY() + down, time, 'V'));
            if (isObstacle(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() + down)))
                break;
        }
        for (int left = 1; left <= bomb.getExplosionRadius() && !isWall(new Position(bomb.getPosition().getX() - left, bomb.getPosition().getY())); left++) {
            explosions.add(new Explosion(bomb.getPosition().getX() - left, bomb.getPosition().getY(), time, 'H'));
            if (isObstacle(new Position(bomb.getPosition().getX() - left, bomb.getPosition().getY())))
                break;
        }
        for (int right = 1; right <= bomb.getExplosionRadius() && !isWall(new Position(bomb.getPosition().getX() + right, bomb.getPosition().getY())); right++) {
            explosions.add(new Explosion(bomb.getPosition().getX() + right, bomb.getPosition().getY(), time, 'H'));
            if (isObstacle(new Position(bomb.getPosition().getX() + right, bomb.getPosition().getY())))
                break;
        }
        for (Explosion explosion : explosions) {
            destroyObstacle(explosion.getPosition());
            killEnemy(explosion.getPosition());
            if (explosion.getPosition().equals(bomberman.getPosition()))
                bomberman.decreaseHp();
        }
    }

    public void destroyObstacle(Position position) {
        for (Obstacle obstacle : obstacles)
            if (obstacle.getPosition().equals(position)) {
                obstacles.remove(obstacle);
                break;
            }
    }

    public void killEnemy(Position position) {
        for (Enemy enemy : enemies)
            if (enemy.getPosition().equals(position)) {
                enemies.remove(enemy);
                break;
            }
    }
}