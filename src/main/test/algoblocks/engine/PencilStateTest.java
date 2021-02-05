package algoblocks.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PencilStateTest {
    @Test
    public void raisedPencilStateCantDraw(){
        PencilState raisedState = new RaisedPencilState();
        Coordinates coords = new Coordinates(0, 0);

        assertTrue(raisedState.draw(coords, coords) instanceof Blank);
    }

    @Test
    public void loweredPencilStateCanDraw(){
        PencilState loweredState = new LoweredPencilState();
        Coordinates coords = new Coordinates(0, 0);

        assertTrue(loweredState.draw(coords, coords) instanceof Line);
    }
}