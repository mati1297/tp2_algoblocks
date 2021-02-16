package algoblocks.engine.grid;

public class Grid {
  private Limits limits;
  private Size gridSize;

  public Grid(int width, int height) {
    limits = new Limits(width, height);
    gridSize = new Size(width, height);
  }

  public Size getSize() {
    return gridSize;
  }

  public Grid() {
    limits = new Limits(10, 10);
  }

  public Coordinates validate(Coordinates position) {
    return limits.validate(position);
  }
}
