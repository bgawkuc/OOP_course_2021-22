package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d,Animal> animalMap = new LinkedHashMap<>();
    protected MapVisualiser mapVisualiser = new MapVisualiser(this);

    protected abstract Vector2d getUpperCorner();
    protected abstract Vector2d getLowerCorner();

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
        Vector2d positionVector = animal.getPosition();
        if (canMoveTo(positionVector)) {
            animalMap.put(positionVector,animal);
            animal.addObserver(this);
            return true;
        }
        throw new IllegalArgumentException(positionVector + " is occupied");
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animalMap.get(position);
    }

    @Override
    public String toString() {
        return mapVisualiser.draw(getLowerCorner(),getUpperCorner());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animalMap.get(oldPosition);
        animalMap.remove(oldPosition,animal);
        animalMap.put(newPosition,animal);
    }
}