package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    private final SortedSet<Vector2d> sortedX = new TreeSet<>(PositionComparator.comparatorX);
    private final SortedSet<Vector2d> sortedY = new TreeSet<>(PositionComparator.comparatorY);

    public MapBoundary() {
    }

    public void addVector(Vector2d object) {
        this.sortedX.add(object);
        this.sortedY.add(object);
    }

    public void removeVector(Vector2d object) {
        this.sortedX.remove(object);
        this.sortedY.remove(object);
    }

    public Vector2d getLowerCorner() {
        if (this.sortedX.isEmpty()) {
            return new Vector2d(0,0);
        }
        return this.sortedX.first().lowerLeft(this.sortedY.first());
    }

    public Vector2d getUpperCorner() {
        if (this.sortedX.isEmpty()) {
            return new Vector2d(0,0);
        }
        return this.sortedX.last().upperRight(this.sortedY.last());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
    }

}
