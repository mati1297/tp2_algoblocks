package algoblocks.engine;

public class PositiveXBound extends Bound {
  public PositiveXBound(int newXBound) {
    super(newXBound);
  }

  public Coordinates validate(Coordinates position) {
    if(position.isXBiggerThan(bound))
      return position.decX();
    return position;
  }
}
