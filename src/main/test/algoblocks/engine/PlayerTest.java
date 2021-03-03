package algoblocks.engine;

import algoblocks.engine.action.*;
import algoblocks.engine.drawing.*;
import algoblocks.engine.grid.Coordinates;
import algoblocks.engine.grid.Grid;
import algoblocks.engine.player.*;

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
        assertTrue(player.canDraw());
    }

    @Test
    public void playerCannotDrawOnRaisedPencilState() {
        Player player = new Player(new Grid());

        player.lowerPencil();
        player.raisePencil();

        Drawing drawing = player.run(new Sequence(new MoveDownAction()));
        
        assertTrue(drawing.isBlank());
        assertFalse(player.canDraw());
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

    @Test
    public void playerMakesNewDrawingEveryTimeItRunsASequence() {
        Player player = new Player(new Grid());

        Sequence inputeSequence1 = new Sequence();
        inputeSequence1.addAction(new LowerPencilAction());
        inputeSequence1.addAction(new MoveLeftAction());

        Drawing expectedDrawing1 = new Drawing();
        expectedDrawing1.addShape(new Line(new Coordinates(), new Coordinates(-1, 0)));

        Drawing outputDrawing1 = player.run(inputeSequence1);

        Sequence inputeSequence2 = new Sequence();
        inputeSequence2.addAction(new RaisePencilAction());
        inputeSequence2.addAction(new MoveDownAction());

        Drawing expectedDrawing2 = new Drawing();
        expectedDrawing2.addShape(new Blank(new Coordinates(-1, 0), new Coordinates(-1, -1)));

        Drawing outputDrawing2 = player.run(inputeSequence2);

        assertTrue(outputDrawing1.equals(expectedDrawing1) && outputDrawing2.equals(expectedDrawing2));
    }

    @Test
    public void resetPlayerToOriginalState() {
        Player player = new Player(new Grid());

        Sequence inputeSequence = new Sequence();
        inputeSequence.addAction(new LowerPencilAction());
        inputeSequence.addAction(new MoveLeftAction());
        inputeSequence.addAction(new MoveDownAction());

        player.run(inputeSequence);

        player.resetPlayer();

        assertTrue(player.equals(new Player(new Grid())));
    }

    @Test
    public void nullIsDifferentToPlayer() {
        Player player = new Player(new Grid(0, 0));

        assertNotEquals(player, null);
    }

    @Test
    public void objectOfOtherClassIsDifferentToPlayer() {
        Player player = new Player(new Grid(0, 0));

        assertNotEquals(player, 5);
    }

    @Test void playerInDifferentPositionsAreDifferent() {
        Player playerOne = new Player(new Grid(10, 10));
        Player playerTwo = new Player(new Grid(10, 10));

        playerOne.move(new DownDirection());

        assertNotEquals(playerOne, playerTwo);
    }

    @Test 
    public void playerSamePositionDifferentDrawingsAreDifferent() {
        Player playerOne = new Player(new Grid(10, 10));
        Player playerTwo = new Player(new Grid(10, 10));

        playerOne.move(new DownDirection());
        playerOne.move(new UpDirection());

        assertNotEquals(playerOne, playerTwo);
    }

    @Test 
    public void playerWithDifferentsStateOfPencilAreDifferent() {
        Player playerOne = new Player(new Grid(10, 10));
        Player playerTwo = new Player(new Grid(10, 10));

        playerOne.lowerPencil();
        playerTwo.raisePencil();

        assertNotEquals(playerOne, playerTwo);
    }
}