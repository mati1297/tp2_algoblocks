package algoblocks.engine.player;

import algoblocks.engine.drawing.Shape;
import algoblocks.engine.grid.Coordinates;

public interface PencilState {
    public Shape draw(Coordinates oldCoords, Coordinates newCoords);
    public boolean canDraw();
}

