package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.action.MoveDownAction;
import algoblocks.engine.action.MoveUpAction;

public class MoveUpBlock extends ActionBlock {
  private static final String blockName = "Move Up";

  public MoveUpBlock() {
    super();
  }

  @Override
  public String getBlockName() {
    return blockName;
  }

  public Sequence getSequence() {
    return new Sequence(new MoveUpAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new MoveDownAction());
  }
}
