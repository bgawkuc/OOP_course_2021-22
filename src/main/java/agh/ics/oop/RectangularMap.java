package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;
    private static final int MAX_VAl = 4;
    private static final int MIN_VAl = 0;


    public RectangularMap(int width, int height) {
        this.width = width > 0 ? width: MAX_VAl;
        this.height = height > 0 ? height: MAX_VAl;
    }
    @Override
    public Vector2d getUpperCorner(){
        return new Vector2d(width,height);
    }

    @Override
    public Vector2d getLowerCorner(){
        return new Vector2d(MIN_VAl,MIN_VAl);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && getLowerCorner().precedes(position) && position.precedes(getUpperCorner());
    }


}
