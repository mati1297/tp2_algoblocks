package algoblocks.engine;

public abstract class Shape {
    private Coordinates start;
    private Coordinates finish;

    public Shape(Coordinates start, Coordinates finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass())
            return false;

        if (this == object)
            return true;

        Shape someShape = (Shape)object;

        return start.equals(someShape.start) && finish.equals(someShape.finish);
    }
}