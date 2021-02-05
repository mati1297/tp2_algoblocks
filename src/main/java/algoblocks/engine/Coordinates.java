package algoblocks.engine;

public class Coordinates {
    private Coordinate x;
    private Coordinate y;

    public Coordinates(){
        x = new Coordinate();
        y = new Coordinate();
    }

    public Coordinates(Coordinates someCoordinates) {
        x = new Coordinate(someCoordinates.x);
        y = new Coordinate(someCoordinates.y);
    }

    public Coordinates(Coordinate newX, Coordinate newY) {
        x = newX;
        y = newY;
    }

    public Coordinates(int newX, int newY) {
        x = new Coordinate(newX);
        y = new Coordinate(newY);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass())
            return false;

        if (this == object)
            return true;

        Coordinates someCoordinates = (Coordinates)object;

        return x.equals(someCoordinates.x) && y.equals(someCoordinates.y);
    }

    public Coordinates incX() {
        return new Coordinates(x.inc(), y);
    }

    public Coordinates decX() {
        return new Coordinates(x.dec(), y);
    }

    public Coordinates incY() {
        return new Coordinates(x, y.inc());
    }

    public Coordinates decY() {
        return new Coordinates(x, y.dec());
    }

    public Coordinates negX() {
        return new Coordinates(x.neg(), y);
    }

    public Coordinates negY() {
        return new Coordinates(x, y.neg());
    }

    public boolean isXLowerThan(Coordinate XCoordinate) {
        return x.isLowerThan(XCoordinate);
    }

    public boolean isXBiggerThan(Coordinate XCoordinate) {
        return x.isBiggerThan(XCoordinate);
    }

    public boolean isYLowerThan(Coordinate YCoordinate) {
        return y.isLowerThan(YCoordinate);
    }

    public boolean isYBiggerThan(Coordinate YCoordinate) {
        return y.isBiggerThan(YCoordinate);
    }
}