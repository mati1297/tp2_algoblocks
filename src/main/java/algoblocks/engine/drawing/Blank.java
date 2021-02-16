package algoblocks.engine.drawing;

import algoblocks.engine.grid.Coordinates;
import javafx.scene.paint.Color;

public class Blank extends Shape {
    public Blank(Coordinates start, Coordinates finish){
        super(start, finish, Color.TRANSPARENT);
    }

    public Shape makeCopy(){
        return new Blank(this.start, this.finish);
    }
}