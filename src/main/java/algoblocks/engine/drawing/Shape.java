package algoblocks.engine.drawing;

import algoblocks.engine.grid.Coordinates;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class Shape {
    protected Coordinates start;
    protected Coordinates finish;
    private Color color;

    public Shape(Coordinates start, Coordinates finish, Color color) {
        this.start = start;
        this.finish = finish;
        this.color = color;
    }

    public abstract Shape makeCopy();

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass())
            return false;

        if (this == object)
            return true;

        Shape someShape = (Shape)object;

        return start.equals(someShape.start) && finish.equals(someShape.finish);
    }

    public Color getColor() {
        return color;
    }

    public Coordinates getStart(){
        return start;
    }

    public Coordinates getFinish(){
        return finish;
    }
}