package algoblocks.engine.grid;

public class Grid {
  private Limits limits;

  public Grid(int length, int height) {
    limits = new Limits(length, height);
  }

  public Grid() {
    limits = new Limits(10, 10);
  }

  public Coordinates validate(Coordinates position) {
    return limits.validate(position);
  }
}
