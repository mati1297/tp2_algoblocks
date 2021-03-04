package algoblocks.engine.player;

import algoblocks.engine.drawing.Shape;
import algoblocks.engine.drawing.Blank;
import algoblocks.engine.grid.Coordinates;

public class RaisedPencilState implements PencilState {
    public Shape draw (Coordinates oldCoords, Coordinates newCoords) {
        oldCoords = new Coordinates(oldCoords);
        newCoords = new Coordinates(newCoords);
        return new Blank(oldCoords, newCoords);
    }

    public boolean canDraw() {
        return false;
    }
}