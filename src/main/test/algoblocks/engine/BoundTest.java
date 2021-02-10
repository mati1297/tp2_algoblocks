package algoblocks.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoundTest {
  @Test
  public void validatePositiveXBound() {
    Bound bound = new PositiveXBound(5);
    Coordinates coordinatesToValidate = new Coordinates(6, 0);
    Coordinates expectedValidatedCoordinates = new Coordinates(5, 0);

    assertTrue(bound.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validateNegativeXBound() {
    Bound bound = new NegativeXBound(-5);
    Coordinates coordinatesToValidate = new Coordinates(-6, 0);
    Coordinates expectedValidatedCoordinates = new Coordinates(-5, 0);

    assertTrue(bound.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validatePositiveYBound() {
    Bound bound = new PositiveYBound(5);
    Coordinates coordinatesToValidate = new Coordinates(0, 6);
    Coordinates expectedValidatedCoordinates = new Coordinates(0, 5);

    assertTrue(bound.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validateNegativeYBound() {
    Bound bound = new NegativeYBound(-5);
    Coordinates coordinatesToValidate = new Coordinates(0, -6);
    Coordinates expectedValidatedCoordinates = new Coordinates(0, -5);

    assertTrue(bound.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validatePositiveXBoundWhenPositionIsEqualToIt() {
    Bound bound = new PositiveXBound(5);
    Coordinates coordinatesToValidate = new Coordinates(5, 0);
    Coordinates expectedValidatedCoordinates = new Coordinates(5, 0);

    assertTrue(bound.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validateNegativeXBoundWhenPositionIsEqualToIt() {
    Bound bound = new NegativeXBound(-5);
    Coordinates coordinatesToValidate = new Coordinates(-5, 0);
    Coordinates expectedValidatedCoordinates = new Coordinates(-5, 0);

    assertTrue(bound.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validatePositiveYBoundWhenPositionIsEqualToIt() {
    Bound bound = new NegativeYBound(5);
    Coordinates coordinatesToValidate = new Coordinates(0, 5);
    Coordinates expectedValidatedCoordinates = new Coordinates(0, 5);

    assertTrue(bound.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validateNegativeYBoundWhenPositionIsEqualToIt() {
    Bound bound = new PositiveYBound(-5);
    Coordinates coordinatesToValidate = new Coordinates(0, -5);
    Coordinates expectedValidatedCoordinates = new Coordinates(0, -5);

    assertTrue(bound.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }
}
