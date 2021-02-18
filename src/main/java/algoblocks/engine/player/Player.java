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

    @Override
    public boolean equals(Object object){
        if (object == null || getClass() != object.getClass())
            return false;

        Player otherPlayer = (Player) object;

        if (!position.equals(otherPlayer.position))
            return false;

        if (!pencil.equals(otherPlayer.pencil))
            return false;

        if (!drawing.equals(otherPlayer.drawing))
            return false;

        return true;
    }

    public void resetPlayer() {
        position = new Coordinates();
        pencil = new Pencil();
        drawing = new Drawing();
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
        pencil.raise();
        sequence.run(this);
        return drawing;
    }

    public Coordinates getPosition(){
        return position;
    }
}