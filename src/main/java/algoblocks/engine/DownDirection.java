package algoblocks.engine;

public class DownDirection implements Direction {
    public Coordinates move(Coordinates position){
        return position.decY();
    }
}
