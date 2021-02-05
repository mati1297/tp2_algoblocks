package algoblocks.engine;

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
  public void DrawingIsDifferentToNull(){
    Drawing drawing = new Drawing();
    
    assertFalse(drawing.equals(null));
  }

  @Test
  public void DrawingIsDifferentToAnObjectOfADifferentClass(){
    Drawing drawing = new Drawing();
    int integer = 0;

    assertFalse(drawing.equals(integer));
  }

  @Test
  public void DrawingIsEqualToItself(){
    Drawing drawing = new Drawing();

    assertTrue(drawing.equals(drawing));
  }

  @Test
  public void DrawingAreDifferentWithDifferentsShapes(){
    Drawing drawingOne = new Drawing();
    Drawing drawingTwo = new Drawing();
    Coordinates coords = new Coordinates();
    
    drawingOne.addShape(new Line(coords, coords));
    drawingTwo.addShape(new Blank(coords, coords));

    assertFalse(drawingOne.equals(drawingTwo));
  }
}
