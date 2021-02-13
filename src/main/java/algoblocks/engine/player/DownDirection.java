package algoblocks.engine.player;

import algoblocks.engine.grid.Coordinates;

public class DownDirection implements Direction {
    public Coordinates move(Coordinates position){
        return position.decY();
    }
}
