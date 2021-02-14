package algoblocks.engine.drawing;

import algoblocks.engine.grid.Coordinates;

public class Blank extends Shape {
    public Blank(Coordinates start, Coordinates finish){
        super(start, finish);
    }

    public Shape makeCopy(){
        return new Blank(this.start, this.finish);
    }
}