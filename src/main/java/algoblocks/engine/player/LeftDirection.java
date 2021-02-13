package algoblocks.engine.player;

import algoblocks.engine.grid.Coordinates;

public class LeftDirection implements Direction{
    public Coordinates move(Coordinates position){
        return position.decX();
    }
}
