package algoblocks.engine.drawing;

import algoblocks.engine.grid.Coordinates;

import java.util.ArrayList;

public abstract class Shape {
    protected Coordinates start;
    protected Coordinates finish;

    public Shape(Coordinates start, Coordinates finish) {
        this.start = start;
        this.finish = finish;
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

    public ArrayList<Integer> getStart(){
        return start.toInt();
    }

    public ArrayList<Integer> getFinish(){
        return finish.toInt();
    }
}