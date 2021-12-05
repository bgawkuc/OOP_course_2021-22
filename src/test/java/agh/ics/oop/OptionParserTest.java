package agh.ics.oop;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptionParserTest {

    @Test
    public void testShouldKnowIfOptionParserWorksGood() {
        String[] allDirections = new String[] {"f","b","b","a","l","r"};
        assertThrows(IllegalArgumentException.class, () -> OptionParser.parse(allDirections));
    }

    @Test
    public void testShouldKnowIfOptionParserWorksGood2() {
        String[] allDirections = new String[] {"f","b","b"};
        ArrayList<MoveDirection> goodDirections = new ArrayList<>(List.of(MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.BACKWARD));
        assertEquals(goodDirections,OptionParser.parse(allDirections));
    }
}
