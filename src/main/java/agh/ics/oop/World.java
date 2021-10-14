package agh.ics.oop;
import static java.lang.System.out;

public class World {

//    na bazie tablicy wartości typu wyliczeniowego opisuje drogę zwierzaka
    public static void run(Direction[] dir) {
        for (Direction move : dir) {

            String choice = switch (move) {
                case F -> "Zwierzak idzie do przodu";
                case B -> "Zwierzak idzie do tyłu";
                case L -> "Zwierzak skręca w lewo";
                case R -> "Zwierzak skręca w prawo";
            };

            out.println(choice);
        }
    }

    //na bazie tablicy wartości typu String opisuje drogę zwierzaka
    public static void run(String[] dir) {
        for (String move : dir) {

            String choice = switch (move) {
                case "f" -> "Forward";
                case "b" -> "Backward";
                case "l" -> "Left";
                case "r" -> "Right";
                default -> null;
            };

            if (choice != null) {out.println(choice);}
        }
    }

//    zmienia tablicę wartości typu String na tablicę wartości typu wyliczeniowego
    public static Direction[] change(String[] moves, int newSize) {
        Direction[] dir = new Direction[newSize];
        int i = 0;

        for (String move: moves) {

            switch (move) {
                case "f" -> {dir[i] = Direction.F; i++;}
                case "b" -> {dir[i] = Direction.B; i++;}
                case "l" -> {dir[i] = Direction.L; i++;}
                case "r" -> {dir[i] = Direction.R; i++;}
                default -> {}}
        }

        return dir;

    }

    public static void main(String[] args) {
        out.println("Start");

//        prawidłowe rodzaje ruchów oraz ilość jaka ich wystąpiła
        String[] correct = new String[] {"l","r","f","b"};
        int newSize = 0;

//        zlicza ilość wystąpień prawidłowych ruchów
        for (String arg : args) {
            for (String move : correct) {
                if (arg.equals(move)) {newSize += 1;break;}
            }
        }

        Direction[] dir;
        dir = change(args,newSize);

        run(dir);
        out.println("Stop");
    }

}
