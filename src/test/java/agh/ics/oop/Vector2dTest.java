package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    Vector2d vector1 = new Vector2d(1, 2);
    Vector2d vector2 = new Vector2d(0, -1);
    Vector2d vector3 = new Vector2d(9, 1);
    Vector2d vector4 = new Vector2d(8, -1);
    Vector2d vector5 = new Vector2d(2, 6);
    Vector2d vector6 = new Vector2d(2, 6);

    @Test
    void testShouldKnowString() {
        assertEquals("(1,2)", vector1.toString());
        assertEquals("(0,-1)", vector2.toString());
        assertEquals("(9,1)", vector3.toString());
    }

    @Test
    void testShouldKnowPrecedesVector() {
        assertTrue(vector2.precedes(vector1));
        assertTrue(vector4.precedes(vector3));
        assertTrue(vector5.precedes(vector6));
    }

    @Test
    void testShouldKnowFollowsVector() {
        assertTrue(vector1.follows(vector2));
        assertTrue(vector3.follows(vector4));
        assertTrue(vector6.follows(vector5));
    }

    @Test
    void testShouldKnowUpperRightVector() {
        assertEquals(new Vector2d(1, 2), vector1.upperRight(vector2));
        assertEquals(new Vector2d(9, 1), vector3.upperRight(vector4));
        assertEquals(new Vector2d(2, 6), vector5.upperRight(vector6));
    }

    @Test
    void testShouldKnowLowerLeftVector() {
        ;
        assertEquals(new Vector2d(0, -1), vector1.lowerLeft(vector2));
        assertEquals(new Vector2d(8, -1), vector3.lowerLeft(vector4));
        assertEquals(new Vector2d(2, 6), vector6.lowerLeft(vector5));
    }

    @Test
    void testShouldKnowAddedVector() {
        assertEquals(new Vector2d(1, 1), vector1.add(vector2));
        assertEquals(new Vector2d(17, 0), vector3.add(vector4));
        assertEquals(new Vector2d(4, 12), vector5.add(vector6));
    }

    @Test
    void testShouldKnowSubtractedVector() {
        assertEquals(new Vector2d(1, 3), vector1.subtract(vector2));
        assertEquals(new Vector2d(1, 2), vector3.subtract(vector4));
        assertEquals(new Vector2d(0, 0), vector5.subtract(vector6));

    }

    @Test
    void testShouldKnowIfVectorsAreEquals() {
        assertEquals(vector5, vector6);
    }

    @Test
    void testShouldKnowOppositeVector() {
        assertEquals(new Vector2d(-1, -2), vector1.opposite());
        assertEquals(new Vector2d(0, 1), vector2.opposite());
        assertEquals(new Vector2d(-9, -1), vector3.opposite());
    }
}