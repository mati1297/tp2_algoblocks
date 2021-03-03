package algoblocks.engine.drawing;

import algoblocks.engine.grid.Coordinates;
import javafx.scene.paint.Color;

public abstract class Shape {
    protected Coordinates start;
    protected Coordinates finish;
    private float alpha;

    public Shape(Coordinates start, Coordinates finish, float alpha) {
        this.start = start;
        this.finish = finish;
        this.alpha = alpha;
    }

    public boolean isDrawable() {
        return alpha != 0;
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

    public float getAlpha() {
        return alpha;
    }

    public Coordinates getStart(){
        return start;
    }

    public Coordinates getFinish(){
        return finish;
    }
}