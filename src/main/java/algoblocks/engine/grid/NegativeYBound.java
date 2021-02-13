package algoblocks.engine.grid;

import algoblocks.engine.grid.Bound;
import algoblocks.engine.grid.Coordinates;

public class NegativeYBound extends Bound {
  public NegativeYBound(int newYBound) {
    super(newYBound);
  }

  public Coordinates validate(Coordinates position) {
    if(position.isYLowerThan(bound))
      return position.incY();
    return position;
  }
}