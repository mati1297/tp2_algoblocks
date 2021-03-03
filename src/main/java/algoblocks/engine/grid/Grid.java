package algoblocks.engine.grid;

public class Grid {
  private Limits limits;
  private Size gridSize;

  public Grid(int width, int height) {
    if(width <= 0 || height <= 0){
      width = 10;
      height = 10;
    }
    limits = new Limits(width, height);
    gridSize = new Size(width, height);
  }

  public Size getSize() {
    return gridSize;
  }

  public Grid() {
    limits = new Limits(10, 10);
    gridSize = new Size(10, 10);
  }

  public Coordinates validate(Coordinates position) {
    return limits.validate(position);
  }
}
