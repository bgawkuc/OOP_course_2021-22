package agh.ics.oop;

import java.util.Comparator;

public class PositionComparator {
    static Comparator<Vector2d> comparatorX = (o1, o2) -> {
        if (o1.x < o2.x) {
            return -1;
        }
        else if (o1.x > o2.x) {
            return 1;
        }
        return 0;
    };

    static Comparator<Vector2d> comparatorY = (o1, o2) -> {
        if (o1.y < o2.y) {
            return -1;
        }
        else if (o1.y > o2.y) {
            return 1;
        }
        return 0;
    };
}