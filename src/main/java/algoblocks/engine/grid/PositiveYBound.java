package algoblocks.engine.grid;

public class PositiveYBound extends Bound {
  public PositiveYBound(int newYBound) {
    super(newYBound);
  }

  public Coordinates validate(Coordinates position) {
    if(position.isYBiggerThan(bound))
      return position.decY().negY();
    return position;
  }
}