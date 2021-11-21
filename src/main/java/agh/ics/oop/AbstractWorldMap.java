package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap{
    protected abstract Vector2d getVectorUpper();
    protected abstract Vector2d getVectorLower();
    protected ArrayList<Animal> animalList = new ArrayList<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return objectAt(position) == null;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getStartVector())) {
            animalList.add(animal);
            return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal: animalList) {
            if (animal.getStartVector().equals(position)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualiser mapVisualiser = new MapVisualiser(this);
        return mapVisualiser.draw(getVectorLower(),getVectorUpper());
    }

}