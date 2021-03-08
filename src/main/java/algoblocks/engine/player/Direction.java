package algoblocks.engine.player;

import algoblocks.engine.grid.Coordinates;

public interface Direction {
    public Coordinates move(Coordinates actualCoords);
}
