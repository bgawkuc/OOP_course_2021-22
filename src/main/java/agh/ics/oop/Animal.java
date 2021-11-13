package agh.ics.oop;

public class Animal {
    private MapDirection startDirection = MapDirection.NORTH;
    private Vector2d startVector = new Vector2d(2,2);
    private static final Vector2d MAX_VECTOR = new Vector2d(4,4);
    private static final Vector2d MIN_VECTOR = new Vector2d(0,0);

    public MapDirection getStartDirection() {
        return startDirection;
    }

    public Vector2d getStartVector() {
        return startVector;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "startDirection=" + startDirection +
                ", startVector=" + startVector +
                '}';
    }

    public void move(MoveDirection direction) {
        Vector2d moveVector = startDirection.toUnitVector();
        Vector2d newVector;

        if (direction == MoveDirection.RIGHT) {
            startDirection = startDirection.next();}

        else if (direction == MoveDirection.LEFT) {
            startDirection = startDirection.previous();}

        else {
            if (direction == MoveDirection.FORWARD) {
                newVector = startVector.add(moveVector);}
            else {
                newVector = startVector.subtract(moveVector);}

            if (newVector.precedes(MAX_VECTOR) && newVector.follows(MIN_VECTOR))
                startVector = newVector;}}
}

