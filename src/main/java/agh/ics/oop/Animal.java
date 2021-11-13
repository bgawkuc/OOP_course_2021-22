package agh.ics.oop;

public class Animal {
    private MapDirection startDirection = MapDirection.NORTH;
    private Vector2d startVector = new Vector2d(2,2);
    private static final Vector2d MAX_VECTOR = new Vector2d(4,4);
    private static final Vector2d MIN_VECTOR = new Vector2d(0,0);
    private final IWorldMap map;

    public Animal() {
        this.startVector = new Vector2d(2, 2);
        this.map = new RectangularMap(4, 4);
    }

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this(map);
        this.startVector = initialPosition;
    }

    public MapDirection getStartDirection() {
        return startDirection;
    }

    public Vector2d getStartVector() {
        return startVector;
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
                newVector = startVector.add(moveVector);
            }
            else {
                newVector = startVector.subtract(moveVector);
            }

            if (map.canMoveTo(newVector)) {
                startVector = newVector;}
        }
    }
}

