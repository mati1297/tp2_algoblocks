package algoblocks.engine;

import algoblocks.engine.drawing.Line;
import algoblocks.engine.drawing.Shape;
import algoblocks.engine.grid.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {
    @Test
    public void ShapeIsDifferentToNull(){
        Coordinates coords = new Coordinates();
        Shape shape = new Line(coords, coords);
    
        assertFalse(shape.equals(null));
    }
    
    @Test
    public void ShapeIsDifferentToAnObjectOfADifferentClass(){
        Coordinates coords = new Coordinates();
        Shape shape = new Line(coords, coords);
        int integer = 0;
    
        assertFalse(shape.equals(integer));
    }
    
    @Test
    public void ShapeIsEqualToItself(){
        Coordinates coords = new Coordinates();
        Shape shape = new Line(coords, coords);
    
        assertTrue(shape.equals(shape));
    }

    @Test
    public void ShapeIsEqualToOtherShapeWithSameStartAndFinish(){
        Coordinates coordsOne = new Coordinates(1, 1);
        Coordinates coordsTwo = new Coordinates(1, 1);
        Shape shapeOne = new Line(coordsOne, coordsOne);
        Shape shapeTwo = new Line(coordsTwo, coordsTwo);
    
        assertTrue(shapeOne.equals(shapeTwo));
    }

    @Test
    public void ShapeAreDifferentWithDifferentStarts(){
        Coordinates coordsOne = new Coordinates(1, 1);
        Coordinates coordsTwo = new Coordinates(2, 2);
        Shape shapeOne = new Line(coordsOne, coordsOne);
        Shape shapeTwo = new Line(coordsTwo, coordsOne);
    
        assertFalse(shapeOne.equals(shapeTwo));
    }

    @Test
    public void ShapeAreDifferentWithDifferentFinish(){
        Coordinates coordsOne = new Coordinates(1, 1);
        Coordinates coordsTwo = new Coordinates(2, 2);
        Shape shapeOne = new Line(coordsTwo, coordsTwo);
        Shape shapeTwo = new Line(coordsTwo, coordsOne);
    
        assertFalse(shapeOne.equals(shapeTwo));
    }
    
    @Test
    public void ShapeGettersReturnOK(){
        Coordinates coordsOne = new Coordinates(1,1);
        Coordinates coordsTwo = new Coordinates(2,2);
        float alpha = 1.0f;


        Shape shape = new Line(coordsOne, coordsTwo);

        assertTrue(coordsOne.equals(shape.getStart()));
        assertTrue(coordsTwo.equals(shape.getFinish()));
        assertTrue(alpha == shape.getAlpha());
    }
}
