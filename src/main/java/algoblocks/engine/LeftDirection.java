package algoblocks.engine;

public class LeftDirection implements Direction{
    public Coordinates move(Coordinates position){
        return position.decX();
    }
}
