package algoblocks.engine;

public class Movement {
    private Grid grid;

    public Movement(Grid newGrid) {
        grid = newGrid;
    }

    public Coordinates move(Direction direction, Coordinates currentPosition) {
        return grid.validate(direction.move(currentPosition));
    }
}