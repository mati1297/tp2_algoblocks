package algoblocks.engine.block;

import algoblocks.engine.grid.Coordinates;
import algoblocks.engine.player.Direction;
import algoblocks.engine.grid.Grid;

public class Movement {
    private Grid grid;

    public Movement(Grid newGrid) {
        grid = newGrid;
    }

    public Coordinates move(Direction direction, Coordinates currentPosition) {
        return grid.validate(direction.move(currentPosition));
    }
}