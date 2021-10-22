package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x;

    public final int y;


    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return x <= other.x && y <= other.y;
    }

    public boolean folllows(Vector2d other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return x >= other.x && y >= other.y;
    }

    public Vector2d upperRight(Vector2d other) {
        int biggerX = Math.max(x,other.x);
        int biggerY = Math.max(y,other.y);
        return new Vector2d(biggerX,biggerY);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int smallerX = Math.max(x,other.x);
        int smallerY = Math.min(y, other.y);
        return new Vector2d(smallerX,smallerY);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(x+other.x,y+other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(Math.abs(x-other.x),Math.abs(y-other.y));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        return x == ((Vector2d) other).x && y == ((Vector2d) other).y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Vector2d opposite(){
        return  new Vector2d(-x,-y);
    }

}
