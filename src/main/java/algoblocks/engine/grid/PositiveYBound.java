package algoblocks.engine.grid;

import algoblocks.engine.grid.Bound;
import algoblocks.engine.grid.Coordinates;

public class PositiveYBound extends Bound {
  public PositiveYBound(int newYBound) {
    super(newYBound);
  }

  public Coordinates validate(Coordinates position) {
    if(position.isYBiggerThan(bound))
      return position.decY();
    return position;
  }
}