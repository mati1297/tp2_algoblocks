package algoblocks.engine;

import algoblocks.engine.grid.Coordinates;
import algoblocks.engine.player.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    public void moveRightDirection(){
        Coordinates firstPosition = new Coordinates();
        Coordinates nextPosition = new Coordinates(1, 0);
        Direction oneDirection = new RightDirection();
    
        assertTrue(nextPosition.equals(oneDirection.move(firstPosition)));
    }

    @Test
    public void moveLeftDirection(){
        Coordinates firstPosition = new Coordinates();
        Coordinates nextPosition = new Coordinates(-1, 0);
        Direction oneDirection = new LeftDirection();

        assertTrue(nextPosition.equals(oneDirection.move(firstPosition)));
    }

    @Test
    public void moveUpDirection(){
        Coordinates firstPosition = new Coordinates();
        Coordinates nextPosition = new Coordinates(0, 1);
        Direction oneDirection = new UpDirection();

        assertTrue(nextPosition.equals(oneDirection.move(firstPosition)));
    }

    @Test
    public void moveDownDirection(){
        Coordinates firstPosition = new Coordinates();
        Coordinates nextPosition = new Coordinates(0, -1);
        Direction oneDirection = new DownDirection();

        assertTrue(nextPosition.equals(oneDirection.move(firstPosition)));
    }


}