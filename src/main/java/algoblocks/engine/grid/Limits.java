package algoblocks.engine.grid;

import java.util.ArrayList;

public class Limits {
  private ArrayList<Bound> limits;

  public Limits(int length, int height) {
    limits = new ArrayList<Bound>();
    limits.add(new NegativeXBound(- length / 2));
    limits.add(new PositiveXBound(length / 2));
    limits.add(new NegativeYBound(- height / 2));
    limits.add(new PositiveYBound(height / 2));
  }

  public Coordinates validate(Coordinates position){
    Coordinates newPosition = new Coordinates(position);

    for(Bound bound : limits)
      newPosition = bound.validate(newPosition);

    return newPosition;
  }
}
