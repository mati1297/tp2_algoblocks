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

    @Test
    public void sizeIsDifferentToNull() {
        Size size = new Size(10, 10);
        assertFalse(size.equals(null));
    }

    @Test
    public void sizeIsDifferentToOtherObject() {
        Size size = new Size(10, 10);
        assertFalse(size.equals(1));
    }

    @Test
    public void twoSizesWithSameAttributesAreEquals() {
        Size sizeOne = new Size(10, 20);
        Size sizeTwo = new Size(10, 20);
        assertTrue(sizeOne.equals(sizeTwo));
    }

    @Test
    public void twoSizesWithDifferentAttributesAreDifferent() {
        Size sizeOne = new Size(15, 30);
        Size sizeTwo = new Size(10, 20);
        assertFalse(sizeOne.equals(sizeTwo));
    }

    @Test
    public void twoSizesWithDifferentXAreDifferent() {
        Size sizeOne = new Size(15, 30);
        Size sizeTwo = new Size(10, 30);
        assertFalse(sizeOne.equals(sizeTwo));
    }

    @Test
    public void twoSizesWithDifferentYAreDifferent() {
        Size sizeOne = new Size(15, 30);
        Size sizeTwo = new Size(15, 31);
        assertFalse(sizeOne.equals(sizeTwo));
    }
}
