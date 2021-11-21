package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private final ArrayList<MoveDirection> moveDirections;
    private final ArrayList<Animal> animalList;
    private final IWorldMap map;

    public SimulationEngine(ArrayList<MoveDirection> moveDirections, IWorldMap map, ArrayList<Vector2d> vector2dList) {
        this.moveDirections = moveDirections;
        this.map = map;
        this.animalList = new ArrayList<>();

        for (Vector2d vector2d: vector2dList) {
            Animal animal = new Animal(map,vector2d);
            if (map.place(animal)) {
                animalList.add(animal);}
        }
    }

    @Override
    public void run() {
        if (animalList.size() == 0) {
            return;
        }
        int idx = 0;

        for (MoveDirection direction : moveDirections) {
            System.out.println(map);
            idx %= animalList.size();
            animalList.get(idx).move(direction);
            idx += 1;
        }
    }
}
