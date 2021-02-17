package algoblocks.engine.player;


import algoblocks.engine.drawing.Line;
import algoblocks.engine.drawing.Blank;
import algoblocks.engine.drawing.Shape;
import algoblocks.engine.grid.Coordinates;

public class LoweredPencilState implements PencilState {
    public Shape draw (Coordinates oldCoords, Coordinates newCoords) {
        oldCoords = new Coordinates(oldCoords);
        newCoords = new Coordinates(newCoords);

        return (
            oldCoords.getDistanceBetween(newCoords) <= 1 ? 
                new Line(oldCoords, newCoords) : 
                new Blank(oldCoords, newCoords)
        );
    }
}