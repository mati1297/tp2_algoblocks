package algoblocks.engine;

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
        sequence.run(this);
        return drawing;
    }

    public Coordinates getPosition(){
        return position;
    }
}