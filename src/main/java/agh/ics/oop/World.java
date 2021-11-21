package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class World {

    public static void main(String[] args) {
        ArrayList<MoveDirection> directions =  OptionParser.parse(args);
        GrassField newGrassField = new GrassField(10);
        ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2,2), new Vector2d(3,4)));
        IEngine engine = new SimulationEngine(directions, newGrassField, positions);
        engine.run();
        System.out.println(newGrassField);
    }
}
