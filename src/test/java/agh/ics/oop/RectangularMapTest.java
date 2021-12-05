package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    void testShouldKnowIfCanMove() {
        RectangularMap rectangularMap = new RectangularMap(3, 7);
        Vector2d vector2d1 = new Vector2d(1, 7);
        Vector2d vector2d2 = new Vector2d(3, 7);
        Vector2d vector2d3 = new Vector2d(4, 7);
        Vector2d vector2d4 = new Vector2d(-2, 1);

        assertTrue(rectangularMap.canMoveTo(vector2d1));
        assertTrue(rectangularMap.canMoveTo(vector2d2));
        assertFalse(rectangularMap.canMoveTo(vector2d3));
        assertFalse(rectangularMap.canMoveTo(vector2d4));
    }

    @Test
    void testShouldKnowIfAnimalCanBePlaced() {
        RectangularMap rectangularMap = new RectangularMap(3, 7);
        Animal animal1 = new Animal(rectangularMap, new Vector2d(4,5));
        Animal animal2 = new Animal(rectangularMap, new Vector2d(3,7));
        Animal animal3 = new Animal(rectangularMap, new Vector2d(3,7));
        assertThrows(IllegalArgumentException.class, () -> rectangularMap.place(animal1));
        assertTrue(rectangularMap.place(animal2));
        assertThrows(IllegalArgumentException.class, () -> rectangularMap.place(animal3));
    }

    @Test
    void testShouldKnowIfPlaceIsOccupied() {
        RectangularMap rectangularMap = new RectangularMap(3, 7);
        Animal animal1 = new Animal(rectangularMap, new Vector2d(2,5));
        Animal animal2 = new Animal(rectangularMap, new Vector2d(3,7));
        rectangularMap.place(animal1);
        rectangularMap.place(animal2);
        assertTrue(rectangularMap.isOccupied(new Vector2d(2,5)));
        assertTrue(rectangularMap.isOccupied(new Vector2d(3,7)));
        assertFalse(rectangularMap.isOccupied(new Vector2d(4,4)));

    }
}
