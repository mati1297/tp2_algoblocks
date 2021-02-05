package algoblocks.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovementTest {
    @Test
    public void moveLeftTest() {
        Movement movement = new Movement(new Grid());

        Coordinates newPosition = movement.move(new LeftDirection(), new Coordinates());

        assertTrue(newPosition.equals(new Coordinates(-1, 0)));
    }

    @Test
    public void moveRightTest() {
        Movement movement = new Movement(new Grid());

        Coordinates newPosition = movement.move(new RightDirection(), new Coordinates());

        assertTrue(newPosition.equals(new Coordinates(1, 0)));
    }

    @Test
    public void moveUpTest() {
        Movement movement = new Movement(new Grid());

        Coordinates newPosition = movement.move(new UpDirection(), new Coordinates());

        assertTrue(newPosition.equals(new Coordinates(0, 1)));
    }

    @Test
    public void moveDownTest() {
        Movement movement = new Movement(new Grid());

        Coordinates newPosition = movement.move(new DownDirection(), new Coordinates());

        assertTrue(newPosition.equals(new Coordinates(0, -1)));
    }

    @Test 
    public void moveInAllDirectionsEndsUpInGridOrigin() {
        Movement movement = new Movement(new Grid());
        Coordinates currentPosition = new Coordinates();

        currentPosition = movement.move(new UpDirection(), currentPosition);
        currentPosition = movement.move(new RightDirection(), currentPosition);
        currentPosition = movement.move(new DownDirection(), currentPosition);
        currentPosition = movement.move(new LeftDirection(), currentPosition);

        assertTrue(currentPosition.equals(new Coordinates()));
    }
}