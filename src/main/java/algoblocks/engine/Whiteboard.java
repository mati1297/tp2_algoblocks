package algoblocks.engine;

import algoblocks.engine.drawing.Drawing;
import algoblocks.engine.grid.Grid;
import algoblocks.engine.grid.Size;

public class Whiteboard {
  Drawing drawing;
  Grid grid;

  public Whiteboard(Grid newGrid) {
    drawing = new Drawing();
    grid = newGrid;
  }

  public Size getSize() {
    return grid.getSize();
  }

  public void draw(Drawing newDrawing) {
    drawing = newDrawing;
  }

  public Drawing getDrawing(){
    return new Drawing(drawing);
  }
}
