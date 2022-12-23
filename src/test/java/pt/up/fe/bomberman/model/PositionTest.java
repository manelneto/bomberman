package pt.up.fe.bomberman.model;

import net.jqwik.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PositionTest {
    @Property
    void getUpTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getUp().getX());
        assertEquals(y - 1, position.getUp().getY());
    }

    @Property
    void getDownTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getDown().getX());
        assertEquals(y + 1, position.getDown().getY());
    }

    @Property
    void getLeftTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x - 1, position.getLeft().getX());
        assertEquals(y, position.getLeft().getY());
    }

    @Property
    void getRightTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x + 1, position.getRight().getX());
        assertEquals(y, position.getRight().getY());
    }

    @Property
    void getDirectionalNeighbourUpTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getDirectionalNeighbour('U').getX());
        assertEquals(y - 1, position.getDirectionalNeighbour('U').getY());
    }

    @Property
    void getDirectionalNeighbourDownTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getDirectionalNeighbour('D').getX());
        assertEquals(y + 1, position.getDirectionalNeighbour('D').getY());
    }

    @Property
    void getDirectionalNeighbourLeftTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x - 1, position.getDirectionalNeighbour('L').getX());
        assertEquals(y, position.getDirectionalNeighbour('L').getY());
    }

    @Property
    void getDirectionalNeighbourRightTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x + 1, position.getDirectionalNeighbour('R').getX());
        assertEquals(y, position.getDirectionalNeighbour('R').getY());
    }

    @Property
    void getDirectionalNeighbourNoneTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getDirectionalNeighbour('X').getX());
        assertEquals(y, position.getDirectionalNeighbour('X').getY());
    }

    @Property
    void getRandomDirectionalNeighbourUpTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        Position destination = position.getRandomDirectionalNeighbour('U');
        assertEquals(x, destination.getX());
        assertTrue(y - 1 == destination.getY() || y + 1 == destination.getY());
    }

    @Property
    void getRandomDirectionalNeighbourDownTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        Position destination = position.getRandomDirectionalNeighbour('D');
        assertEquals(x, destination.getX());
        assertTrue(y - 1 == destination.getY() || y + 1 == destination.getY());
    }

    @Property
    void getRandomDirectionalNeighbourLeftTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        Position destination = position.getRandomDirectionalNeighbour('L');
        assertTrue(x - 1 == destination.getX() || x + 1 == destination.getX());
        assertEquals(y, destination.getY());
    }

    @Property
    void getRandomDirectionalNeighbourRightTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        Position destination = position.getRandomDirectionalNeighbour('R');
        assertTrue(x - 1 == destination.getX() || x + 1 == destination.getX());
        assertEquals(y, destination.getY());
    }

    @Property
    void getRandomDirectionalNeighbourNoneTest(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getDirectionalNeighbour('X').getX());
        assertEquals(y, position.getDirectionalNeighbour('X').getY());
    }
}
