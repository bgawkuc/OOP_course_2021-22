package agh.ics.oop;

import java.util.ArrayList;

public class World {

    public static void main(String[] args) {
        Animal animal = new Animal();

        String[] array = new String[] {"r","a","f","f","o","f"};
        ArrayList<MoveDirection> directions = OptionParser.parse(array);
        for (MoveDirection newMove: directions) {
            animal.move(newMove);
            System.out.println(animal);
        }

    }
}
