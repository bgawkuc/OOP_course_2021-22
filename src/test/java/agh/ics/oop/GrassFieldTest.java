package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
//    dla zmian wykonanych w lab5 wszystkie testy nadal są zaliczone

    @Test
    void testShouldKnowIfPlaceIsOccupied() {
        GrassField grassField = new GrassField(0);
        Animal animal1 = new Animal(grassField,new Vector2d(2,3));
        Animal animal2 = new Animal(grassField,new Vector2d(-2,3));
        Animal animal3 = new Animal(grassField,new Vector2d(1,8));
        grassField.place(animal1);
        grassField.place(animal2);
        grassField.place(animal3);
        assertTrue(grassField.isOccupied(new Vector2d(2,3)));
        assertTrue(grassField.isOccupied(new Vector2d(-2,3)));
        assertTrue(grassField.isOccupied(new Vector2d(1,8)));
    }

    @Test
    void testShouldIfAnimalWasPlacedGood() {
        GrassField grassField = new GrassField(0);
        Animal animal1 = new Animal(grassField,new Vector2d(1,9));
        Animal animal2 = new Animal(grassField,new Vector2d(1,9));
        Animal animal3 = new Animal(grassField,new Vector2d(2,9));
        assertTrue(grassField.place(animal1));
        assertThrows(IllegalArgumentException.class, () -> grassField.place(animal2));
        assertTrue(grassField.place(animal3));
    }

    @Test
    void testShouldKnowUpperLowerVector() {
        GrassField grassField = new GrassField(0);
        Animal animal1 = new Animal(grassField,new Vector2d(1,6));
        Animal animal2 = new Animal(grassField,new Vector2d(0,3));
        Animal animal3 = new Animal(grassField,new Vector2d(2,5));
        grassField.place(animal1);
        grassField.place(animal2);
        grassField.place(animal3);
        Vector2d lowerVector = new Vector2d(0,3);
        Vector2d upperVector = new Vector2d(2,6);
        assertEquals(lowerVector,grassField.getLowerCorner());
        assertEquals(upperVector,grassField.getUpperCorner());
    }

    @Test
    void testShouldCountNumberOfGrass() {
        GrassField grassField = new GrassField(4);
        int field = (int) Math.floor(Math.sqrt(10 * 4));
        int cnt = 0;
        for (int i = 0; i <= field; i++) {
            for (int j = 0; j <= field; j++) {
                if (grassField.objectAt(new Vector2d(i,j)) != null) {
                    cnt ++;
                }
            }
        }
        assertEquals(cnt,4);
    }
}