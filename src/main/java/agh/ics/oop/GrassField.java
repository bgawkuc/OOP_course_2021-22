package agh.ics.oop;

import java.util.ArrayList;

public class GrassField extends AbstractWorldMap {
    protected ArrayList<Grass> grassArrayList = new ArrayList<>();
    private static final int MIN = 0;
    private static final int INF_POSITIVE = (int) Double.POSITIVE_INFINITY;
    private static final int INF_NEGATIVE = (int) Double.NEGATIVE_INFINITY;

    public GrassField(int grassNumber) {
        int max = (int) Math.floor(Math.sqrt(10 * grassNumber));

        Vector2d grassVector = generateGrassVector(MIN, max);
        for (int i = 0; i < grassNumber; i++) {
            while (isOccupied(grassVector)) {
                grassVector = generateGrassVector(MIN, max);
            }
            grassArrayList.add(new Grass(grassVector));
        }
    }

    public int generateRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)));
    }

    public Vector2d generateGrassVector(int minField, int maxField) {
        return new Vector2d(generateRandomNumber(minField, maxField), generateRandomNumber(minField, maxField));
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) != null) {
            return super.objectAt(position);
        }
        for (Grass grass: grassArrayList) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }

    @Override
    public Vector2d getVectorLower() {
        if (animalArrayList.size() == 0 && grassArrayList.size() == 0) {
            return new Vector2d(0,0);
        }
        Vector2d minVector = new Vector2d(INF_POSITIVE,INF_POSITIVE);

        for (Animal animal : animalArrayList) {
            minVector = minVector.lowerLeft(animal.getStartVector());
        }
        for (Grass grass : grassArrayList) {
            minVector = minVector.lowerLeft(grass.getPosition());
        }
        return minVector;
    }

    @Override
    public Vector2d getVectorUpper() {
        if (animalArrayList.size() == 0 && grassArrayList.size() == 0) {
            return new Vector2d(0,0);
        }
        Vector2d maxVector = new Vector2d(INF_NEGATIVE,INF_NEGATIVE);
        for (Animal animal: animalArrayList) {
            maxVector = maxVector.upperRight(animal.getStartVector());
        }
        for (Grass grass: grassArrayList) {
            maxVector = maxVector.upperRight(grass.getPosition());
        }
        return maxVector;
    }
}