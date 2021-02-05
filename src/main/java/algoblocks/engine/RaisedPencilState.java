package algoblocks.engine;

public class RaisedPencilState implements PencilState {
    public Shape draw (Coordinates oldCoords, Coordinates newCoords) {
        oldCoords = new Coordinates(oldCoords);
        newCoords = new Coordinates(newCoords);
        return new Blank(oldCoords, newCoords);
    }
}