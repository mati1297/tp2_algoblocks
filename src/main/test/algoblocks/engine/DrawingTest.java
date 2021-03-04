package algoblocks.engine;

import algoblocks.engine.grid.Coordinates;
import algoblocks.engine.drawing.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrawingTest {
    @Test
    public void drawingIsCreatedEmpty() {
        Drawing drawing = new Drawing();
        assertTrue(drawing.isEmpty());
    }

    @Test
    public void drawingIsCreatedBlank() {
        Drawing drawing = new Drawing();
        assertTrue(drawing.isBlank());
    }

    @Test
    public void drawingWithBlankIsBlank() {
        Drawing drawing = new Drawing();
        drawing.addShape(new Blank(new Coordinates(), new Coordinates()));

        assertTrue(drawing.isBlank());
    }

    @Test
    public void drawingWithLineIsntBlank() {
        Drawing drawing = new Drawing();
        drawing.addShape(new Line(new Coordinates(), new Coordinates()));

        assertFalse(drawing.isBlank());
    }

    @Test
    public void drawingIsDifferentToNull() {
        Drawing drawing = new Drawing();
        
        assertFalse(drawing.equals(null));
    }

    @Test
    public void drawingIsDifferentToAnObjectOfADifferentClass() {
        Drawing drawing = new Drawing();
        int integer = 0;

        assertFalse(drawing.equals(integer));
    }

    @Test
    public void drawingIsEqualToItself() {
        Drawing drawing = new Drawing();

        assertTrue(drawing.equals(drawing));
    }

    @Test
    public void drawingAreDifferentWithDifferentsShapes() {
        Drawing drawingOne = new Drawing();
        Drawing drawingTwo = new Drawing();
        Coordinates coords = new Coordinates();
        
        drawingOne.addShape(new Line(coords, coords));
        drawingTwo.addShape(new Blank(coords, coords));

        assertFalse(drawingOne.equals(drawingTwo));
    }

    @Test
    public void drawingCopyConstructorCopiesAnotherDrawing() {
        Drawing drawingOne = new Drawing();
        Coordinates coords = new Coordinates();

        drawingOne.addShape(new Line(coords, coords));
        drawingOne.addShape(new Blank(coords, coords));
        
        Drawing drawingTwo = new Drawing(drawingOne);

        assertTrue(drawingTwo.equals(drawingOne));
    }

    @Test
    public void forEachIteratesDrawing() {
        Drawing drawingOne = new Drawing();
        Drawing drawingTwo = new Drawing();
        Coordinates coords = new Coordinates();

        Shape line = new Line(coords, coords);
        Shape blank = new Blank(coords, coords);

        drawingOne.addShape(line);
        drawingOne.addShape(blank);

        drawingOne.forEach((Shape shape) -> {
        drawingTwo.addShape(shape);
        });

        assertTrue(drawingOne.equals(drawingTwo));
    }
}
