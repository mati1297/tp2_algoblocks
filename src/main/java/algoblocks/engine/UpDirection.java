package algoblocks.engine;

public class UpDirection implements Direction {
    public Coordinates move(Coordinates position){
        return position.incY();
    }
}
