package algoblocks.engine.grid;

import algoblocks.engine.grid.Bound;
import algoblocks.engine.grid.Coordinates;

public class NegativeXBound extends Bound {
  public NegativeXBound(int newXBound) {
    super(newXBound);
  }

  public Coordinates validate(Coordinates position) {
    if(position.isXLowerThan(bound))
      return position.incX();
    return position;
  }
}
