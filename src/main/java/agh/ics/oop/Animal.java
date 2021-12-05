package agh.ics.oop;

import java.util.ArrayList;

public class Animal {
    private MapDirection startDirection = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private final IWorldMap map;
    private ArrayList<IPositionChangeObserver> observerArrayList;

    public Animal() {
        this.position = new Vector2d(2, 2);
        this.map = new RectangularMap(4, 4);
        this.observerArrayList = new ArrayList<>();
    }

    public Animal(IWorldMap map) {
        this.map = map;
        this.observerArrayList = new ArrayList<>();

    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this(map);
        this.position = initialPosition;
        this.observerArrayList = new ArrayList<>();

    }

    public MapDirection getStartDirection() {
        return startDirection;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return switch (startDirection) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
    }

    public void move(MoveDirection direction) {
        Vector2d moveVector = startDirection.toUnitVector();
        Vector2d newVector;

        if (direction == MoveDirection.RIGHT) {
            startDirection = startDirection.next();
        }
        else if (direction == MoveDirection.LEFT) {
            startDirection = startDirection.previous();
        }
        else {
            if (direction == MoveDirection.FORWARD) {
                newVector = position.add(moveVector);
            }
            else {
                newVector = position.subtract(moveVector);
            }

            if (map.canMoveTo(newVector)) {
                positionChanged(position,newVector);
                position = newVector;}
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        observerArrayList.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observerArrayList.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition,Vector2d newPosition) {
        for (IPositionChangeObserver observer: observerArrayList) {
            observer.positionChanged(oldPosition,newPosition);
        }
    }
}

