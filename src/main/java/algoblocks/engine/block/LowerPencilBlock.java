package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.action.LowerPencilAction;
import algoblocks.engine.action.RaisePencilAction;

public class LowerPencilBlock extends ActionBlock {
  public LowerPencilBlock() {
    super("Lower Pencil");
  }

  public Sequence getSequence() {
    return new Sequence(new LowerPencilAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new RaisePencilAction());
  }
}
