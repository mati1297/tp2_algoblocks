package algoblocks.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algoblocks.engine.grid.Size;

public class SizeTest {
  @Test
  public void sizeObjectIsCreatedCorrectly() {
    Size size = new Size(10, 20);
    assertTrue(size.width() == 10 && size.height() == 20);
  }
}
