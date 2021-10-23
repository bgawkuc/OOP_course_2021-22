package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MapDirectionTest {
    MapDirection north = MapDirection.NORTH;
    MapDirection south = MapDirection.SOUTH;
    MapDirection east = MapDirection.EAST;
    MapDirection west = MapDirection.WEST;

    @Test
    public void testShouldKnowNextDirection() {
        assertEquals(north, west.next());
        assertEquals(south, east.next());
        assertEquals(east, north.next());
        assertEquals(west, south.next());
    }

    @Test
    public void testShouldKnowPreviousDirection() {
        assertEquals(north, east.previous());
        assertEquals(south, west.previous());
        assertEquals(east, south.previous());
        assertEquals(west, north.previous());
    }
}