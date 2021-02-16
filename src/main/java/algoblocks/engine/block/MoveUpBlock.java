package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.action.MoveDownAction;
import algoblocks.engine.action.MoveUpAction;

public class MoveUpBlock extends ActionBlock {
  public MoveUpBlock() {
    super("Move Up");
  }

  public Sequence getSequence() {
    return new Sequence(new MoveUpAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new MoveDownAction());
  }
}
