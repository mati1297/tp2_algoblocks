package algoblocks.engine.player;

import algoblocks.engine.grid.Coordinates;

public class RightDirection implements Direction{
    public Coordinates move(Coordinates position) {
        return position.incX();
    }
}
