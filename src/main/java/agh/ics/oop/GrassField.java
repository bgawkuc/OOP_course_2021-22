package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
    protected Map<Vector2d, Grass> grassMap = new LinkedHashMap<>();
    private final MapBoundary mapBoundary;
    int max;

    public GrassField(int grassNumber) {
        max = (int) Math.floor(Math.sqrt(10 * grassNumber));
        this.mapBoundary = new MapBoundary();
        addGrass(grassNumber);
    }

    private void addGrass(int grassNumber) {
        ArrayList<Integer> free = freePositions();

        while (free.size() > 0 && grassNumber > 0) {
            int randomIdx = generateRandomInt(free.size()/2);
            Vector2d grassVector = new Vector2d(free.get(randomIdx*2), free.get(randomIdx*2+1));
            free.remove(randomIdx*2+1);
            free.remove(randomIdx*2);
            grassMap.put(grassVector, new Grass(grassVector));
            mapBoundary.addVector(grassVector);
            grassNumber -= 1;
        }
    }

    private ArrayList<Integer> freePositions() {
        ArrayList<Integer> free = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            for (int j = 0; j <= max; j++) {
                if (objectAt(new Vector2d(i, j)) == null) {
                    free.add(i);
                    free.add(j);
                }
            }
        }
        return free;
    }

    private int generateRandomInt(int max) {
        return (int) ((Math.random() * max));
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) != null) {
            return super.objectAt(position);
        }
        for (Grass grass : grassMap.values()) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }

//    zwierzak 'zjada' trawę i na jej miesce musi wyrosnąć nowa
    @Override
    public boolean place(Animal animal) {
        Vector2d positionVector = animal.getPosition();

        if (objectAt(positionVector) == null || objectAt(positionVector) instanceof Grass) {
            if (objectAt(positionVector) instanceof Grass) {
                addGrass(1);
            }
            animalMap.put(positionVector, animal);
            animal.addObserver(this);
            this.mapBoundary.addVector(animal.getPosition());
            return true;
        }
        throw new IllegalArgumentException(positionVector + " is occupied");
    }

    @Override
    public Vector2d getLowerCorner() {
        return mapBoundary.getLowerCorner();
    }

    @Override
    public Vector2d getUpperCorner() {
        return mapBoundary.getUpperCorner();
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        super.positionChanged(oldPosition, newPosition);
        mapBoundary.removeVector(oldPosition);
        mapBoundary.addVector(newPosition);
    }
}