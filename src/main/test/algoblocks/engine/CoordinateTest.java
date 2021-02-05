package algoblocks.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {

    @Test
    public void coordinate10IsBiggerThanCoordinate2(){
        Coordinate c1 = new Coordinate(10);
        Coordinate c2 = new Coordinate(2);

        assertTrue(c1.isBiggerThan(c2));
    }

    @Test
    public void coordinate1IsLowerThanCoordinate2(){
        Coordinate c1 = new Coordinate(1);
        Coordinate c2 = new Coordinate(2);

        assertTrue(c1.isLowerThan(c2));
    }

    @Test
    public void coordinate5DecrementsTwiceAndIsLowerThatCoordinate4(){
        Coordinate c1 = new Coordinate(5);
        Coordinate c2 = new Coordinate(4);

        c1 = c1.dec();
        c1 = c1.dec();

        assertTrue(c1.isLowerThan(c2));
    }

    @Test
    public void coordinate1IncrementsTwiceAndIsBiggerThatCoordinate2(){
        Coordinate c1 = new Coordinate(1);
        Coordinate c2 = new Coordinate(2);

        c1 = c1.inc();
        c1 = c1.inc();

        assertTrue(c1.isBiggerThan(c2));
    }

    @Test
    public void coordinate1NegatesAndIsEqualToCoordinateMinus1(){
        Coordinate c1 = new Coordinate(1);
        Coordinate c2 = new Coordinate(-1);

        c1 = c1.neg();

        assertTrue(c1.equals(c2));
    }

    @Test
    public void intCreatedCoordinateIsEqualToCopyCreatedCoordinate(){
        Coordinate intCoord = new Coordinate(10);
        Coordinate copyCoord = new Coordinate(intCoord);

        assertTrue(intCoord.equals(copyCoord));
    }

    @Test
    public void CompareCoordinateWithAnObjectOfADifferentClass(){
        Coordinate coord = new Coordinate();
        int integer = 10;

        assertFalse(coord.equals(integer));
    }

    @Test 
    public void CompareCoordinateWithNull(){
        Coordinate coord = new Coordinate();

        assertFalse(coord.equals(null));
    }

    @Test
    public void CompareCoordinateWithItself(){
        Coordinate coord = new Coordinate();
        
        assertTrue(coord.equals(coord));
    }
}
