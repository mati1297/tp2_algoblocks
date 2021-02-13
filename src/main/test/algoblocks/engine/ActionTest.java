package algoblocks.engine;

import algoblocks.engine.action.Action;
import algoblocks.engine.action.MoveDownAction;
import algoblocks.engine.action.MoveUpAction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ActionTest {
  @Test
  public void ActionIsEqualToOtherAction(){
    Action actionOne = new MoveUpAction();
    Action actionTwo = new MoveUpAction();

    assertTrue(actionOne.equals(actionTwo));
  }

  @Test
  public void ActionIsDifferentToOtherAction(){
    Action actionOne = new MoveUpAction();
    Action actionTwo = new MoveDownAction();

    assertFalse(actionOne.equals(actionTwo));
  }

  @Test
  public void ActionIsDifferentToNull(){
    Action action = new MoveUpAction();

    assertFalse(action.equals(null));
  }
}
