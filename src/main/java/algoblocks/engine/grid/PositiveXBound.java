package algoblocks.engine.grid;

public class PositiveXBound extends Bound {
  public PositiveXBound(int newXBound) {
    super(newXBound);
  }

  public Coordinates validate(Coordinates position) {
    if(position.isXBiggerThan(bound))
      return position.decX().negX();
    return position;
  }
}
