package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.action.MoveDownAction;
import algoblocks.engine.action.MoveUpAction;

public class MoveDownBlock implements ActionBlock {
  public Sequence getSequence() {
    return new Sequence(new MoveDownAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new MoveUpAction());
  }
}
