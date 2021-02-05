package algoblocks.engine;

public class Coordinate {
    private int coordinate;

    public Coordinate(int newCoordinate) {
        coordinate = newCoordinate;
    }

    public Coordinate() {
        coordinate = 0;
    }

    public Coordinate(Coordinate newCoordinate) {
        coordinate = newCoordinate.coordinate;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass())
            return false;

        if (this == object)
            return true;

        Coordinate someCoordinate = (Coordinate)object;

        return coordinate == someCoordinate.coordinate;
    }

    public Coordinate inc() {
        return new Coordinate(coordinate + 1);
    }

    public Coordinate dec() {
        return new Coordinate(coordinate - 1);
    }

    public Coordinate neg() {
        return new Coordinate(coordinate * -1);
    }

    public boolean isLowerThan(Coordinate otherCoordinate) {
        return coordinate < otherCoordinate.coordinate;
    }

    public boolean isBiggerThan(Coordinate otherCoordinate) {
        return coordinate > otherCoordinate.coordinate;
    }
}
