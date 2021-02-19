package algoblocks.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algoblocks.engine.grid.Size;
import jdk.jfr.Timestamp;

public class SizeTest {
  @Test
  public void sizeObjectIsCreatedCorrectly() {
    Size size = new Size(10, 20);
    assertTrue(size.width() == 10 && size.height() == 20);
  }

  @Test
  public void SizeIsDifferentToNull(){
    Size size = new Size(10, 10);
    assertFalse(size.equals(null));
  }

  @Test
  public void SizeIsDifferentToOtherObject(){
    Size size = new Size(10, 10);
    assertFalse(size.equals(1));
  }

  @Test
  public void TwoSizesWithSameAttributesAreEquals(){
    Size sizeOne = new Size(10, 20);
    Size sizeTwo = new Size(10, 20);
    assertTrue(sizeOne.equals(sizeTwo));
  }

  @Test
  public void TwoSizesWithDifferentAttributesAreDifferent(){
    Size sizeOne = new Size(15, 30);
    Size sizeTwo = new Size(10, 20);
    assertFalse(sizeOne.equals(sizeTwo));
  }

  @Test
  public void TwoSizesWithDifferentXAreDifferent(){
    Size sizeOne = new Size(15, 30);
    Size sizeTwo = new Size(10, 30);
    assertFalse(sizeOne.equals(sizeTwo));
  }

  @Test
  public void TwoSizesWithDifferentYAreDifferent(){
    Size sizeOne = new Size(15, 30);
    Size sizeTwo = new Size(15, 31);
    assertFalse(sizeOne.equals(sizeTwo));
  }
}
