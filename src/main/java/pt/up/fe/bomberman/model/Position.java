package pt.up.fe.bomberman.model;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getUp() {
        return new Position(x, y - 1);
    }

    public Position getRight() {
        return new Position(x + 1, y);
    }

    public Position getDown() {
        return new Position(x, y + 1);
    }

    public Position getLeft() {
        return new Position(x - 1, y);
    }

    public Position getRandomNeighbour() {
        int n = (int) (Math.random() * 4);
        /*
        return switch (n) {
            case 0: return getUp();
            case 1: return getRight();
            case 2: return getDown();
            default: return  getLeft();
        }*/
        if(n==0)return getUp();if(n==1)return getRight();if(n==2)return getDown();else return getLeft();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
