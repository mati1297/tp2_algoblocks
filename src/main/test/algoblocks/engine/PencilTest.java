package algoblocks.engine;

import algoblocks.engine.drawing.Blank;
import algoblocks.engine.drawing.Line;
import algoblocks.engine.grid.Coordinates;
import algoblocks.engine.player.Pencil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PencilTest {
    @Test
    public void newPencilCantDraw() {
        Pencil pencil = new Pencil();

        Coordinates start = new Coordinates(0, 0);
        Coordinates finish = new Coordinates(0, 1);

        Blank blank = new Blank(start, finish);

        assertEquals(pencil.draw(start, finish), blank);
    }

    @Test
    public void loweredPencilCanDraw() {
        Pencil pencil = new Pencil();

        Coordinates start = new Coordinates(0, 0);
        Coordinates finish = new Coordinates(0, 1);

        Line line = new Line(start, finish);

        pencil.lower();

        assertEquals(pencil.draw(start, finish), line);
    }

    @Test
    public void raisedPencilCantDraw() {
        Pencil pencil = new Pencil();

        Coordinates start = new Coordinates(0, 0);
        Coordinates finish = new Coordinates(0, 1);
        
        Blank blank = new Blank(start, finish);

        pencil.raise();
        
        assertEquals(pencil.draw(start, finish), blank);
    }

    @Test
    public void nullIsDiferentToPencil(){
        Pencil pencil = new Pencil();

        assertNotEquals(pencil, null);
    }

    @Test
    public void objectOfOtherClassIsDifferentToPencil(){
        Pencil pencil = new Pencil();

        assertNotEquals(pencil, 5);
    }

    @Test
    public void pencilRaisedIsDifferentToLowered(){
        Pencil pencilRaised = new Pencil();
        Pencil pencilLowered = new Pencil();

        pencilRaised.raise();
        pencilLowered.lower();

        assertNotEquals(pencilRaised, pencilLowered);
    }
}