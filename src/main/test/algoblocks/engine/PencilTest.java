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

        assertTrue(pencil.draw(start, finish) instanceof Blank);
    }

    @Test
    public void loweredPencilCanDraw() {
        Pencil pencil = new Pencil();

        Coordinates start = new Coordinates(0, 0);
        Coordinates finish = new Coordinates(0, 1);

        pencil.lower();
        assertTrue(pencil.draw(start, finish) instanceof Line);
    }

    @Test
    public void raisedPencilCantDraw() {
        Pencil pencil = new Pencil();

        Coordinates start = new Coordinates(0, 0);
        Coordinates finish = new Coordinates(0, 1);

        pencil.raise();
        assertTrue(pencil.draw(start, finish) instanceof Blank);
    }
}