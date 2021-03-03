package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.action.LowerPencilAction;
import algoblocks.engine.action.RaisePencilAction;

public class RaisePencilBlock extends ActionBlock {
  private static final String blockName = "Raise Pencil";

  public RaisePencilBlock() {
    super();
  }

  @Override
  public String getBlockName() {
    return blockName;
  }

  public Sequence getSequence() {
    return new Sequence(new RaisePencilAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new LowerPencilAction());
  }
}
