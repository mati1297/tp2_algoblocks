package algoblocks.engine.player;

import algoblocks.engine.drawing.Shape;
import algoblocks.engine.grid.Coordinates;

public class Pencil {
    private PencilState state;

    public Pencil() {
        state = new RaisedPencilState();
    }

    @Override
    public boolean equals(Object object){
        if (object == null || getClass() != object.getClass())
            return false;

        Pencil otherPencil = (Pencil) object;

        if (state.getClass() != otherPencil.state.getClass())
            return false;

        return true;
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