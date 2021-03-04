package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.action.LowerPencilAction;
import algoblocks.engine.action.RaisePencilAction;

public class LowerPencilBlock extends ActionBlock {

  public LowerPencilBlock() {
    super(BlockNames.LOWER_PENCIL);
  }

  public LowerPencilBlock(LowerPencilBlock original){
    super(original);
  }

  public Sequence getSequence() {
    return new Sequence(new LowerPencilAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new RaisePencilAction());
  }
}
