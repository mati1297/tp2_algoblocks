package algoblocks.engine.grid;

public class NegativeXBound extends Bound {
  public NegativeXBound(int newXBound) {
    super(newXBound);
  }

  public Coordinates validate(Coordinates position) {
    if(position.isXLowerThan(bound))
      return position.incX().negX();
    return position;
  }
}
