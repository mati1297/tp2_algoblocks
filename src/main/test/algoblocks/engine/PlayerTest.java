package algoblocks.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void newPlayerCannotDraw() {
        Player player = new Player(new Grid());
        Drawing drawing = player.run(new Sequence(new MoveDownAction()));

        assertTrue(drawing.isBlank());
    }

    @Test
    public void playerHasToLowerPencilToDraw() {
        Player player = new Player(new Grid());
        player.lowerPencil();

        Drawing drawing = player.run(new Sequence(new MoveDownAction()));
        
        assertFalse(drawing.isBlank());
    }

    @Test
    public void playerCannotDrawOnRaisedPencilState() {
        Player player = new Player(new Grid());

        player.lowerPencil();
        player.raisePencil();

        Drawing drawing = player.run(new Sequence(new MoveDownAction()));
        
        assertTrue(drawing.isBlank());
    }

    @Test
    public void playerMovesUpAndDraws() {
        Player player = new Player(new Grid());
        Line expectedLine = new Line(new Coordinates(), new Coordinates(0, 1));

        player.lowerPencil();
        Drawing drawing = player.run(new Sequence(new MoveUpAction()));

        assertTrue(drawing.get(0).equals(expectedLine));
    }

    @Test
    public void playerMovesDownAndDraws() {
        Player player = new Player(new Grid());
        Line expectedLine = new Line(new Coordinates(), new Coordinates(0, -1));

        player.lowerPencil();
        Drawing drawing = player.run(new Sequence(new MoveDownAction()));

        assertTrue(drawing.get(0).equals(expectedLine));
    }

    @Test
    public void playerMovesLeftAndDraws() {
        Player player = new Player(new Grid());
        Line expectedLine = new Line(new Coordinates(), new Coordinates(-1, 0));

        player.lowerPencil();
        Drawing drawing = player.run(new Sequence(new MoveLeftAction()));

        assertTrue(drawing.get(0).equals(expectedLine));
    }

    @Test
    public void playerMovesRightAndDraws() {
        Player player = new Player(new Grid());
        Line expectedLine = new Line(new Coordinates(), new Coordinates(1, 0));

        player.lowerPencil();
        Drawing drawing = player.run(new Sequence(new MoveRightAction()));

        assertTrue(drawing.get(0).equals(expectedLine));
    }

    @Test
    public void playerExecutes2Actions() {
        Player player = new Player(new Grid());

        Sequence inputeSequence = new Sequence();
        inputeSequence.addAction(new LowerPencilAction());
        inputeSequence.addAction(new MoveLeftAction());
        inputeSequence.addAction(new RaisePencilAction());
        inputeSequence.addAction(new MoveDownAction());

        Drawing expectedDrawing = new Drawing();
        expectedDrawing.addShape(new Line(new Coordinates(), new Coordinates(-1, 0)));
        expectedDrawing.addShape(new Blank(new Coordinates(-1, 0), new Coordinates(-1, -1)));

        Drawing outputDrawing = player.run(inputeSequence);

        assertTrue(outputDrawing.equals(expectedDrawing));
    }
}