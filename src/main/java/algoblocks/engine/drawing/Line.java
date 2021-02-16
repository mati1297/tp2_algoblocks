package algoblocks.engine.drawing;

import algoblocks.engine.grid.Coordinates;
import javafx.scene.paint.Color;

public class Line extends Shape {
    public Line(Coordinates start, Coordinates finish){
        super(start, finish, Color.BLACK);
    }

    public Shape makeCopy(){
        return new Line(this.start, this.finish);
    }
}
