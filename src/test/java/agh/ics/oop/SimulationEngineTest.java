package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {
    //    dla zmian wykonanych w lab5 wszystkie testy nadal są zaliczone

    String[] arg = new String[] {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
    ArrayList<MoveDirection> directions =  OptionParser.parse(arg);
    IWorldMap map = new RectangularMap(10, 5);
    ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2,2), new Vector2d(3,4)));
    IEngine engine = new SimulationEngine(directions, map, positions);
    Vector2d finalLeft = new Vector2d(2,0);
    Vector2d finalRight = new Vector2d(3,5);

    @Test
    public void testShouldKnowIfLastPositionIsGood() {
        engine.run();
        assertTrue(map.isOccupied(finalLeft));
        assertTrue(map.isOccupied(finalRight));
    }

    String[] arg1 = new String[] {"b","f","b","f","b","f","b","f"};
    ArrayList<MoveDirection> directions1 =  OptionParser.parse(arg1);
    IWorldMap map1 = new RectangularMap(3, 3);
    ArrayList<Vector2d> positions1 = new ArrayList<>(Arrays.asList(new Vector2d(2,2), new Vector2d(2,1)));
    IEngine engine1 = new SimulationEngine(directions1, map1, positions1);
    Vector2d finalLeft1 = new Vector2d(2,2);
    Vector2d finalRight1 = new Vector2d(2,1);

    @Test
    public void testShouldKnowIfLastPositionIsGood1() {
        engine1.run();
        assertTrue(map1.isOccupied(finalLeft1));
        assertTrue(map1.isOccupied(finalRight1));
    }

}