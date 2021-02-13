package algoblocks.engine.player;

import algoblocks.engine.grid.Coordinates;

public class UpDirection implements Direction {
    public Coordinates move(Coordinates position){
        return position.incY();
    }
}
