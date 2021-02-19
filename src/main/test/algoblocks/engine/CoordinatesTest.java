package algoblocks.engine;

import algoblocks.engine.grid.Coordinate;
import algoblocks.engine.grid.Coordinates;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoordinatesTest {

    @Test
    public void coordinateCreatedCoordinatesEqualsCopyCreatedCoordinates(){
        Coordinates coordinates = new Coordinates(new Coordinate(10), new Coordinate(5));
        Coordinates copyCoordinates = new Coordinates(coordinates);

        assertTrue(coordinates.equals(copyCoordinates));
    }

    @Test
    public void copyCoordinatesIncrementXAndAreNotEqual(){
        Coordinates c = new Coordinates(1, 1);
        Coordinates cp = new Coordinates(c);

        cp = cp.incX();

        assertFalse(cp.equals(c));
    }

    @Test
    public void moveCoordinatesFrom0_0To2_2(){
        Coordinates c = new Coordinates();
        c = c.incX();
        c = c.incX();
        c = c.incY();
        c = c.incY();

        assertTrue(c.equals(new Coordinates(2, 2)));
    }

    @Test
    public void moveCoordinatesFrom1_1ToMinus1_Minus1(){
        Coordinates c = new Coordinates(new Coordinate(1), new Coordinate(1));
        c = c.decX();
        c = c.decX();
        c = c.decY();
        c = c.decY();

        assertTrue(c.equals(new Coordinates(new Coordinate(-1), new Coordinate(-1))));
    }

    @Test
    public void coordinatesFrom0_5HasBiggerYThan1AndLowerXThan2(){
        Coordinates c1 = new Coordinates(new Coordinate(0), new Coordinate(5));

        assertTrue(c1.isYBiggerThan(new Coordinate(1)) && c1.isXLowerThan(new Coordinate(2)));
    }

    @Test
    public void negatedCoordinatesMinus1_3HasBiggerXThan0AndLowerYThan2(){
        Coordinates c = new Coordinates(new Coordinate(-1), new Coordinate(3));

        c = c.negX();
        c = c.negY();

        assertTrue(c.isXBiggerThan(new Coordinate(0)) && c.isYLowerThan(new Coordinate(2)));
    }

    @Test
    public void CoordinatesIsDifferentToNull(){
        Coordinates coords = new Coordinates();

        assertFalse(coords.equals(null));
    }

    @Test
    public void CoordinatesIsDifferentToAnObjectOfADifferentClass(){
        Coordinates coords = new Coordinates();
        int integer = 0;

        assertFalse(coords.equals(integer));
    }

    @Test
    public void CoordinatesIsEqualToItself(){
        Coordinates coords = new Coordinates();

        assertTrue(coords.equals(coords));
    }

    @Test
    public void CoordinatesWithDifferentXAreDifferent(){
        Coordinates coordsOne = new Coordinates(5, 10);
        Coordinates coordsTwo = new Coordinates(4, 10);

        assertFalse(coordsOne.equals(coordsTwo));
    }

    @Test
    public void CoordinatesWithDifferentYAreDifferent(){
        Coordinates coordsOne = new Coordinates(5, 10);
        Coordinates coordsTwo = new Coordinates(5, 9);

        assertFalse(coordsOne.equals(coordsTwo));
    }

    @Test
    public void CoordinatesReturnCorrectIntValues(){
        int valueX = 2;
        int valueY = 4;
        Coordinates coords = new Coordinates(valueX, valueY);

        assertEquals(valueX, coords.getX());
        assertEquals(valueY, coords.getY());
    }
}
