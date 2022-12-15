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

    public Position getDirectionalNeighbour(char direction) {
        switch (direction) {
            case 'U':
                return getUp();
            case 'D':
                return getDown();
            case 'L':
                return getLeft();
            case 'R':
                return getRight();
            default:
                return new Position(x, y);
        }
    }

    public Position getRandomNeighbour() {
        int n = (int) (Math.random() * 5);
        switch (n) {
            case 0:
                return getUp();
            case 1:
                return getRight();
            case 2:
                return getDown();
            case 3:
                return getLeft();
            default:
                return new Position(x, y);
        }
    }

    public Position getRandomDirectionalNeighbour(char direction) {
        if (direction == 'L' || direction == 'R')
            return getRandomHorizontalNeighbour();
        if (direction == 'U' || direction == 'D')
            return getRandomVerticalNeighbour();
        else
            return new Position(x, y);
    }

    public Position getRandomVerticalNeighbour() {
        int n = (int) (Math.random() * 2);
        switch (n) {
            case 0:
                return getUp();
            case 1:
                return getDown();
            default:
                return new Position(x, y);
        }
    }

    public Position getRandomHorizontalNeighbour() {
        int n = (int) (Math.random() * 2);
        switch (n) {
            case 0:
                return getRight();
            case 1:
                return getLeft();
            default:
                return new Position(x, y);
        }
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

