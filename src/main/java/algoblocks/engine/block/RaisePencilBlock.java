package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.action.LowerPencilAction;
import algoblocks.engine.action.RaisePencilAction;

public class RaisePencilBlock extends ActionBlock {
  public RaisePencilBlock() {
    super("Raise Pencil");
  }

  public Sequence getSequence() {
    return new Sequence(new RaisePencilAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new LowerPencilAction());
  }
}
