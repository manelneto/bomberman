package pt.up.fe.bomberman.model.game.elements;

import pt.up.fe.bomberman.model.Position;

public abstract class Enemy extends Element {

    public Enemy(int x, int y, int speed, int smart, boolean wallpass) {
        super(x, y);
        this.speed = speed;
        this.smart = smart;
        this.wallpass = wallpass;
    }
    public char getType() {
        return 'B';
    }

    private char getRandomDirection(){

        int n = (int) (Math.random() * 4);

        switch (n) {
            case 0:
                return 'U';
            case 1:
                return 'D';
            case 2:
                return 'L';
            default:
                return 'R';


        }
    }
    public Position movePaternrandom(){

        int n = (int) (Math.random() * 4);

        switch (n) {
            case 0:
                setDirection('U');
                return getPosition().getUp();
            case 1:
                setDirection('D');
                return getPosition().getDown();
            case 2:
                setDirection('R');
                return getPosition().getRight();
            default:
                setDirection('L');
                return getPosition().getLeft();


        }
    }
    public  Position getmovePatern(){
        return movePaternrandom();
    }

    public char getDirection() {
        return direction;
    }
    public void setDirection(char c) {
        direction=c;
    }
    public boolean canWallpass() {return wallpass;}

    private final int speed;
    private final int smart;
    private final boolean wallpass;

    private char direction=getRandomDirection();

    //canMove personalized based on speed, smart and wallpass

}
