package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d,Animal> animalMap = new LinkedHashMap<>();

    protected abstract Vector2d getVectorUpper();
    protected abstract Vector2d getVectorLower();

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
        Vector2d positionVector = animal.getStartVector();
        if (canMoveTo(positionVector)) {
            animalMap.put(positionVector,animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animalMap.get(position);
    }

    @Override
    public String toString() {
        MapVisualiser mapVisualiser = new MapVisualiser(this);
        return mapVisualiser.draw(getVectorLower(),getVectorUpper());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animalMap.get(oldPosition);
        animalMap.remove(oldPosition,animal);
        animalMap.put(newPosition,animal);
    }
}