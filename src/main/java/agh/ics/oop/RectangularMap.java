package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    private final int width;
    private final int heigth;
    private static final int MAX_VAl = 4;
    private static final int MIN_VAl = 0;
    private final ArrayList<Animal> animalList = new ArrayList<>();
    private final MapVisualiser mapVisualiser = new MapVisualiser(this);

    public RectangularMap(int width, int heigth) {
        this.width = width > 0 ? width: MAX_VAl;
        this.heigth = heigth > 0 ? heigth: MAX_VAl;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position)) {return false;}
        else {
            Vector2d newVectorUpper = new Vector2d(width,heigth);
            Vector2d newVectorLower = new Vector2d(MIN_VAl,MIN_VAl);
            return newVectorLower.precedes(position) && position.precedes(newVectorUpper);
        }
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getStartVector())) {
            animalList.add(animal);
            return true;
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: animalList) {
            if (animal.getStartVector().equals(position)) {return true;}
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animalList) {
            if (animal.getStartVector().equals(position)) {return animal.getStartVector();}
        }
        return null;
    }

    @Override
    public String toString() {
        Vector2d newVectorUpper = new Vector2d(width,heigth);
        Vector2d newVectorLower = new Vector2d(MIN_VAl,MIN_VAl);
        return mapVisualiser.draw(newVectorLower,newVectorUpper);
    }
}
