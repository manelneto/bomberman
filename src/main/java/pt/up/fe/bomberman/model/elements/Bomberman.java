package pt.up.fe.bomberman.model.elements;

public class Bomberman extends Element {
    private int hp;
    public Bomberman(int x, int y) {super(x, y); hp=1;}
    public int getHp(){return hp;}

    public void TakesHit(){
        hp--;
    }
}
