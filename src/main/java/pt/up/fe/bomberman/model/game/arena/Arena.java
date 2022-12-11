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

    public List<Explosion> getExplosion(){
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

    public List<Powerup> getPowerups() { return powerups; }

    public void setBomberman(Bomberman bomberman) {
        this.bomberman = bomberman;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
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

    public boolean isEmpty(Position position) {
        for (Obstacle obstacle : obstacles)
            if (obstacle.getPosition().equals(position))
                return false;
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isEnemy(Position position){
        for (Enemy enemy : enemies)
            if (enemy.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isPowerup(Position position){
        for (Powerup powerup : powerups)
            return (powerup.getPosition().equals(position));
        return false;
    }

    public Powerup findPowerup(Position position){
        for (Powerup powerup : powerups)
            if (powerup.getPosition().equals(position))
                return powerup;
        return null;
    }

    /*private void UpdateRealExplosionData(long time){
        for(int i=1;i<=getBomb().getExplodeRadius();i++){
            explosion.add(new Explosion(getBomb().getPosition().getX(),getBomb().getPosition().getY()+i,time,'V'));
            explosion.add(new Explosion(getBomb().getPosition().getX(),getBomb().getPosition().getY()-i,time,'V'));
        }
        for(int i=1;i<=getBomb().getExplodeRadius();i++){
            explosion.add(new Explosion(getBomb().getPosition().getX()+i,getBomb().getPosition().getY(),time,'H'));
            explosion.add(new Explosion(getBomb().getPosition().getX()-i,getBomb().getPosition().getY(),time,'H'));
        }
        List<Explosion> delExplo =new ArrayList<>();
        for(Wall wall : walls){
            for(Explosion explosion1 : explosion  ) {
                if(explosion1.getPosition().equals(wall.getPosition())) delExplo.add(explosion1);
            }
        }
        for(Explosion dell: delExplo)
            explosion.remove(dell);
    }
    private void DestroyOb(){

        ArrayList<Obstacle> DestroyedObs=new ArrayList<>();
        for(Obstacle obstacle : obstacles){
            for(Explosion explosion1 : explosion  ) {
                if(explosion1.getPosition().equals(obstacle.getPosition())) DestroyedObs.add(obstacle);
            }
        }
        for(Obstacle dell: DestroyedObs)
            obstacles.remove(dell);
    }
    private void KillEnemies(){
        ArrayList<Enemy> Enemieskilled=new ArrayList<>();
        for(Explosion explosion1 : explosion  ) {
            for(Enemy enemy:enemies){
                if(enemy.getPosition().equals(explosion1.getPosition())) Enemieskilled.add(enemy);
            }

        }
        for(Enemy enemy: Enemieskilled)
            enemies.remove(enemy);
    }
    private void checksuicide(){

        for(Explosion explosion1 : explosion  ) {
            if(getBomberman().getPosition().equals(explosion1.getPosition()))
                getBomberman().TakesHit();
        }
    }
    public void Explode(long time){

        UpdateRealExplosionData(time);

        DestroyOb();

        KillEnemies();

        checksuicide();


        Hasbomb=false;
    }


    public void ClearExplosion() {
        explosion.clear();
    }
*/
}