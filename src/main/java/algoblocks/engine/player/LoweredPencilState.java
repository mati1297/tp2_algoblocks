package algoblocks.engine.player;


import algoblocks.engine.drawing.Line;
import algoblocks.engine.drawing.Shape;
import algoblocks.engine.grid.Coordinates;

public class LoweredPencilState implements PencilState {
    public Shape draw (Coordinates oldCoords, Coordinates newCoords) {
        oldCoords = new Coordinates(oldCoords);
        newCoords = new Coordinates(newCoords);
        return (new Line(oldCoords, newCoords));
    }
}