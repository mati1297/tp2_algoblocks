package algoblocks.engine.drawing;

import algoblocks.engine.grid.Coordinates;

public class Line extends Shape {
    public Line(Coordinates start, Coordinates finish){
        super(start, finish);
    }

    public Shape makeCopy(){
        return new Line(this.start, this.finish);
    }
}
