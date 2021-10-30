package agh.ics.oop;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Animal animal1 = new Animal();
    String[] array1 = new String[] {"j","f","f","k","f"};
    ArrayList<MoveDirection> directions1 = OptionParser.parse(array1);
    ArrayList<MoveDirection> checkedDirections1 = new ArrayList<>(Arrays.asList(MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD)) ;
    Vector2d vector1 = new Vector2d(0,2);

    Animal animal2 = new Animal();
    String[] array2 = new String[] {"f","b","i","b"};
    ArrayList<MoveDirection> directions2 = OptionParser.parse(array2);
    ArrayList<MoveDirection> checkedDirections2 = new ArrayList<>(Arrays.asList(MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.BACKWARD)) ;
    Vector2d vector2a = new Vector2d(2,3);
    Vector2d vector2b = new Vector2d(2,4);


    @Test
    public void testShouldKnowIfAnimalClassWorksGood() {
        assertEquals(MapDirection.NORTH, animal1.getStartDirection());
        animal1.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, animal1.getStartDirection());
        animal1.move(MoveDirection.LEFT);
        assertEquals(MapDirection.SOUTH, animal1.getStartDirection());
        animal1.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST, animal1.getStartDirection());
        assertEquals(directions1, checkedDirections1);
        for (MoveDirection dir : directions1) {
            animal1.move(dir);
        }
        assertEquals(vector1, animal1.getStartVector());

        assertEquals(MapDirection.NORTH, animal2.getStartDirection());
        animal2.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, animal2.getStartDirection());
        animal2.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, animal2.getStartDirection());
        animal2.move(MoveDirection.BACKWARD);
        assertEquals(vector2a, animal2.getStartVector());
        animal2.move(MoveDirection.BACKWARD);
        assertEquals(vector2b, animal2.getStartVector());
        assertEquals(directions2, checkedDirections2);
        for (MoveDirection dir : directions2) {
            animal2.move(dir);
        }
        assertEquals(vector2b, animal2.getStartVector());
    }

}