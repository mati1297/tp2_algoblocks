package algoblocks.engine;

public class Whiteboard {
  Drawing drawing;
  Grid grid;

  public Whiteboard(Grid newGrid) {
    drawing = new Drawing();
    grid = newGrid;
  }

  public void draw(Drawing newDrawing) {
    drawing = newDrawing;
  }
}
