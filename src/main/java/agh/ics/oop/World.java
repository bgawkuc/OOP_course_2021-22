package agh.ics.oop;

import java.util.ArrayList;

public class World {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);

        String[] array = new String[] {"b","a","f","f","b","f"};
        ArrayList<MoveDirection> directions = OptionParser.parse(array);
        for (MoveDirection newMove: directions) {
            animal.move(newMove);
            System.out.println(animal);
        }

    }
}
