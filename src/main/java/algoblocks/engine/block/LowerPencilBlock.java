package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.action.LowerPencilAction;
import algoblocks.engine.action.RaisePencilAction;

public class LowerPencilBlock extends ActionBlock {
  private static final String blockName = "Lower Pencil";

  public LowerPencilBlock() {
    super();
  }

  @Override
  public String getBlockName() {
    return blockName;
  }

  public Sequence getSequence() {
    return new Sequence(new LowerPencilAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new RaisePencilAction());
  }
}
