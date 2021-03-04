package algoblocks.engine.grid;

public abstract class Bound {
    protected Coordinate bound;

    public Bound(int coordinate) {
        bound = new Coordinate(coordinate);
    }

    public abstract Coordinates validate(Coordinates position);
}
