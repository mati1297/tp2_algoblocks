package algoblocks.engine;

import algoblocks.engine.grid.Coordinates;
import algoblocks.engine.grid.Grid;
import org.junit.jupiter.api.Test;
import algoblocks.engine.grid.Size;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {
  @Test
  public void validatePositiveXBound() {
    Grid grid = new Grid();
    Coordinates coordinatesToValidate = new Coordinates(6, 0);
    Coordinates expectedValidatedCoordinates = new Coordinates(-5, 0);

    assertTrue(grid.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validateNegativeXBound() {
    Grid grid = new Grid();
    Coordinates coordinatesToValidate = new Coordinates(-6, 0);
    Coordinates expectedValidatedCoordinates = new Coordinates(5, 0);

    assertTrue(grid.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validatePositiveYBound() {
    Grid grid = new Grid();
    Coordinates coordinatesToValidate = new Coordinates(0, 6);
    Coordinates expectedValidatedCoordinates = new Coordinates(0, -5);

    assertTrue(grid.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validateNegativeYBound() {
    Grid grid = new Grid();
    Coordinates coordinatesToValidate = new Coordinates(0, -6);
    Coordinates expectedValidatedCoordinates = new Coordinates(0, 5);

    assertTrue(grid.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validatePositiveXBoundWhenPositionIsEqualToIt() {
    Grid grid = new Grid();
    Coordinates coordinatesToValidate = new Coordinates(5, 0);
    Coordinates expectedValidatedCoordinates = new Coordinates(5, 0);

    assertTrue(grid.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validateNegativeXBoundWhenPositionIsEqualToIt() {
    Grid grid = new Grid();
    Coordinates coordinatesToValidate = new Coordinates(-5, 0);
    Coordinates expectedValidatedCoordinates = new Coordinates(-5, 0);

    assertTrue(grid.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validatePositiveYBoundWhenPositionIsEqualToIt() {
    Grid grid = new Grid();
    Coordinates coordinatesToValidate = new Coordinates(0, 5);
    Coordinates expectedValidatedCoordinates = new Coordinates(0, 5);

    assertTrue(grid.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void validateNegativeYBoundWhenPositionIsEqualToIt() {
    Grid grid = new Grid();
    Coordinates coordinatesToValidate = new Coordinates(0, -5);
    Coordinates expectedValidatedCoordinates = new Coordinates(0, -5);

    assertTrue(grid.validate(coordinatesToValidate).equals(expectedValidatedCoordinates));
  }

  @Test
  public void verifyGridSize() {
    Grid grid = new Grid(5, 6);
    assertTrue(grid.getSize().equals(new Size(5, 6)));
  }

  @Test
  public void createInvalidSizedGridAndSizeSetsToDefault(){
    Grid grid = new Grid(-1, 2);
    Size size = new Size(10, 10);

    assertTrue(grid.getSize().equals(size));
  }
}
