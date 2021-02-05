package algoblocks.engine;


public class LoweredPencilState implements PencilState {
    public Shape draw (Coordinates oldCoords, Coordinates newCoords) {
        oldCoords = new Coordinates(oldCoords);
        newCoords = new Coordinates(newCoords);
        return (new Line(oldCoords, newCoords));
    }
}