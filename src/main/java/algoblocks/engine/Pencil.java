package algoblocks.engine;

public class Pencil {
    private PencilState state;

    public Pencil() {
        state = new RaisedPencilState();
    }

    public Shape draw(Coordinates start, Coordinates finish) {
        return state.draw(start, finish);
    }

    public void raise() {
        state = new RaisedPencilState();
    }

    public void lower() {
        state = new LoweredPencilState();
    }
}