package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.action.MoveLeftAction;
import algoblocks.engine.action.MoveRightAction;

public class MoveRightBlock extends ActionBlock {
  private static final String blockName = "Move Right";
  
  public MoveRightBlock() {
    super();
  }

  @Override
  public String getBlockName() {
    return blockName;
  }

  public Sequence getSequence() {
    return new Sequence(new MoveRightAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new MoveLeftAction());
  }
}
