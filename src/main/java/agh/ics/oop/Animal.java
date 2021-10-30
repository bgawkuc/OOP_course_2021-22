package agh.ics.oop;

public class Animal {

    private MapDirection startDirection = MapDirection.NORTH;
    private Vector2d startVector = new Vector2d(2,2);

    public MapDirection getStartDirection() {
        return startDirection;
    }

    public Vector2d getStartVector() {
        return startVector;
    }
    
    @Override
    public String toString() {
        return "Animal{" +
                "startDirection = " + startDirection +
                ", startVector = " + startVector +
                '}';
    }

    public void move(MoveDirection direction) {
        Vector2d moveVector = startDirection.toUnitVector();

        if (direction == MoveDirection.RIGHT) {
            startDirection = startDirection.next();}

        else if (direction == MoveDirection.LEFT) {
            startDirection = startDirection.previous();
        }

        else {

            if ((startDirection == MapDirection.NORTH || startDirection == MapDirection.SOUTH) && startVector.y > 0 && startVector.y < 4 ) {
                if (direction == MoveDirection.BACKWARD) {startVector = startVector.subtract(moveVector);}
                else {startVector = startVector.add(moveVector);}
            }

            else if ((startDirection == MapDirection.EAST || startDirection == MapDirection.WEST) && startVector.x > 0 && startVector.x < 4 ) {
                if (direction == MoveDirection.BACKWARD) {startVector = startVector.subtract(moveVector);}
                else {startVector = startVector.add(moveVector);}
            }
        }

    }
}
