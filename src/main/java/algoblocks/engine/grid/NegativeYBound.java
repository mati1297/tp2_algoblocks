package algoblocks.engine.grid;

public class NegativeYBound extends Bound {
  public NegativeYBound(int newYBound) {
    super(newYBound);
  }

  public Coordinates validate(Coordinates position) {
    if(position.isYLowerThan(bound))
      return position.incY().negY();
    return position;
  }
}