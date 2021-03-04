package algoblocks.engine.drawing;

import algoblocks.engine.grid.Coordinates;

public class Blank extends Shape {
    public Blank(Coordinates start, Coordinates finish) {
        super(start, finish, 0f);
    }

    public Shape makeCopy() {
        return new Blank(this.start, this.finish);
    }
}