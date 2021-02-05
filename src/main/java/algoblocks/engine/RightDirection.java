package algoblocks.engine;

public class RightDirection implements Direction{
    public Coordinates move(Coordinates position){
        return position.incX();
    }
}
