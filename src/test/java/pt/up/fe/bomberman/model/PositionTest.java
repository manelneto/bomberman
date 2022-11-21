package pt.up.fe.bomberman.model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Property
    void getUp(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getUp().getX());
        assertEquals(y - 1, position.getUp().getY());
    }

    @Property
    void getRight(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x + 1, position.getRight().getX());
        assertEquals(y, position.getRight().getY());
    }

    @Property
    void getDown(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getDown().getX());
        assertEquals(y + 1, position.getDown().getY());
    }
}
