package algoblocks.engine.player;

import algoblocks.engine.drawing.Drawing;
import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.Movement;
import algoblocks.engine.grid.Coordinates;
import algoblocks.engine.grid.Grid;

public class Player {
    private Pencil pencil;
    private Coordinates position;
    private Movement movement;
    private Drawing drawing;

    public Player(Grid grid) {
        pencil = new Pencil();
        position = new Coordinates();
        movement = new Movement(grid);
        drawing = new Drawing();
    }

    public void resetPosition() {
        position = new Coordinates();
    }

    public void move(Direction direction) {
        Coordinates newPosition = movement.move(direction, position);
        drawing.addShape(pencil.draw(new Coordinates(position), newPosition));
        position = newPosition;
    }

    public void lowerPencil() {
        pencil.lower();
    }

    public void raisePencil() {
        pencil.raise();
    }

    public Drawing run(Sequence sequence) {
        drawing = new Drawing();
        sequence.run(this);
        return drawing;
    }

    public Coordinates getPosition(){
        return position;
    }
}