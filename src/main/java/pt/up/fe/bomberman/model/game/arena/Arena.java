package pt.up.fe.bomberman.model.game.arena;

import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Bomberman bomberman;
    private List<Bomb> bombs;
    private List<Flame> flames;
    private List<Obstacle> obstacles;
    private List<Wall> walls;
    private List<Enemy> enemies;
    private List<Powerup> powerups;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        bombs = new ArrayList<>();
        flames = new ArrayList<>();
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
    public List<Flame> getFlames() {
        return flames;
    }
    public List<Obstacle> getObstacles() {
        return obstacles;
    }
    public List<Wall> getWalls() {
        return walls;
    }
    public List<Enemy> getEnemies() {
        return enemies;
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
    public void setFlames(List<Flame> flames) {
        this.flames = flames;
    }
    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }
    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }
    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }
    public void setPowerups(List<Powerup> powerups) {
        this.powerups = powerups;
    }

    public void createBomb(long time) {
        if (!isBomb(bomberman.getPosition()) && !isObstacle(bomberman.getPosition()) && !isWall(bomberman.getPosition()) && !isPowerup(bomberman.getPosition()) && !isPowerup(bomberman.getPosition())) {
            Bomb bomb = new Bomb(bomberman.getPosition().getX(), bomberman.getPosition().getY(), time, getBomberman().getFlames());
            bombs.add(bomb);
        }
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
    public void removePowerup(Position position) {
        for (Powerup powerup : powerups)
            if (powerup.getPosition().equals(position)) {
                powerups.remove(powerup);
                break;
                }
    }

    public boolean isWall(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return true;
        return false;
    }

    public Powerup getPowerup(Position position) {
        for (Powerup powerup : powerups)
            if (powerup.getPosition().equals(position))
                return powerup;
        return null;
    }

    public void explodeBomb(Bomb bomb, long time) {
        flames.add(new Flame(bomb.getPosition().getX(), bomb.getPosition().getY(), time, 'H'));
        for (int up = 1; up <= bomb.getFlames() && !isWall(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() - up)); up++) {
            flames.add(new Flame(bomb.getPosition().getX(), bomb.getPosition().getY() - up, time, 'V'));
            if (isObstacle(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() - up))) {
                break;
            }
        }
        for (int down = 1; down <= bomb.getFlames() && !isWall(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() + down)); down++) {
            flames.add(new Flame(bomb.getPosition().getX(), bomb.getPosition().getY() + down, time, 'V'));
            if (isObstacle(new Position(bomb.getPosition().getX(), bomb.getPosition().getY() + down)))
                break;
        }
        for (int left = 1; left <= bomb.getFlames() && !isWall(new Position(bomb.getPosition().getX() - left, bomb.getPosition().getY())); left++) {
            flames.add(new Flame(bomb.getPosition().getX() - left, bomb.getPosition().getY(), time, 'H'));
            if (isObstacle(new Position(bomb.getPosition().getX() - left, bomb.getPosition().getY())))
                break;
        }
        for (int right = 1; right <= bomb.getFlames() && !isWall(new Position(bomb.getPosition().getX() + right, bomb.getPosition().getY())); right++) {
            flames.add(new Flame(bomb.getPosition().getX() + right, bomb.getPosition().getY(), time, 'H'));
            if (isObstacle(new Position(bomb.getPosition().getX() + right, bomb.getPosition().getY())))
                break;
        }
        for (Flame flame : this.flames) {
            destroyObstacle(flame.getPosition());
            killEnemy(flame.getPosition());
            if (flame.getPosition().equals(bomberman.getPosition()) && !bomberman. canFlamepass())
                bomberman.setHp(bomberman.getHp() - 1);
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

    public boolean inArena(Position position) {
        if(0<=position.getX() && position.getX()<width && 0<=position.getY() && position.getY()<height) return true;
        return false;
    }
}