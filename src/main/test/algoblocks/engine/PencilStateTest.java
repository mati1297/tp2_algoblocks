package algoblocks.engine;

import algoblocks.engine.drawing.*;
import algoblocks.engine.grid.Coordinates;
import algoblocks.engine.player.LoweredPencilState;
import algoblocks.engine.player.PencilState;
import algoblocks.engine.player.RaisedPencilState;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PencilStateTest {
    @Test
    public void raisedPencilStateCantDraw() {
        PencilState raisedState = new RaisedPencilState();
        Coordinates coords = new Coordinates(0, 0);

        Blank blank = new Blank(coords, coords);
        
        assertFalse(raisedState.canDraw());
        assertEquals(raisedState.draw(coords, coords), blank);
    }

    @Test
    public void loweredPencilStateCanDraw() {
        PencilState loweredState = new LoweredPencilState();
        Coordinates coords = new Coordinates(0, 0);

        Line line = new Line(coords, coords);

        assertTrue(loweredState.canDraw());
        assertEquals(loweredState.draw(coords, coords), line);
    }

}