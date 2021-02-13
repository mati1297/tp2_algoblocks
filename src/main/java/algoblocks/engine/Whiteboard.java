package algoblocks.engine;

import algoblocks.engine.drawing.Drawing;
import algoblocks.engine.grid.Grid;

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
