package agh.ics.oop;

import java.util.ArrayList;

public class OptionParser {

    public static ArrayList<MoveDirection> parse(String[] array) {
        ArrayList<MoveDirection> directions = new ArrayList<>();

        for (String element: array) {
            switch (element) {
                case "f", "forward" -> directions.add(MoveDirection.FORWARD);
                case "b", "backward" -> directions.add(MoveDirection.BACKWARD);
                case "l", "left" -> directions.add(MoveDirection.LEFT);
                case "r", "right" -> directions.add(MoveDirection.RIGHT);
                default -> {}
            }
        }

        return directions;

    }
}
