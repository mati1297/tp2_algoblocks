package algoblocks.engine;

import algoblocks.engine.drawing.*;
import algoblocks.engine.grid.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WhiteboardTest {
    @Test
    public void getSizeOfWhiteboardReturnsCorrectSize() {
        int x = 5;
        int y = 2;
        Whiteboard whiteboard = new Whiteboard(new Grid(x, y));

        Size size = whiteboard.getSize();

        assertEquals(size.width(), x);
        assertEquals(size.height(), y);
    }

    @Test
    public void getDrawingOfWhiteboardReturnsACopyOfDrawing() {
        Drawing drawing = new Drawing();
        Grid grid = new Grid(5, 5);

        Whiteboard whiteboard = new Whiteboard(grid);
        whiteboard.draw(drawing);

        Drawing newDrawing = whiteboard.getDrawing();

        assertTrue(newDrawing.equals(drawing));
        assertFalse(newDrawing == drawing);
    }
}
