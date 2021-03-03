package algoblocks.engine;

import algoblocks.engine.action.Action;
import algoblocks.engine.action.MoveDownAction;
import algoblocks.engine.action.MoveUpAction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActionTest {
    @Test
    public void actionIsEqualToOtherAction() {
        Action actionOne = new MoveUpAction();
        Action actionTwo = new MoveUpAction();

        assertTrue(actionOne.equals(actionTwo));
    }

    @Test
    public void actionIsDifferentToOtherAction() {
        Action actionOne = new MoveUpAction();
        Action actionTwo = new MoveDownAction();

        assertFalse(actionOne.equals(actionTwo));
    }

    @Test
    public void actionIsDifferentToNull() {
        Action action = new MoveUpAction();

        assertFalse(action.equals(null));
    }
}
