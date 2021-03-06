package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

public class InvertBlock extends EffectBlock {

  public InvertBlock(){
    super(BlockNames.INVERT);
  }

  public InvertBlock(InvertBlock original){
    super(original);
  }

  public Sequence getSequence() {
    Sequence sequence = new Sequence();
    for(Block block: blocks)
      sequence.concatenate(block.getInvertedSequence());
    return sequence;
  }

  public Sequence getInvertedSequence() {
    Sequence sequence = new Sequence();
    for(Block block: blocks)
      sequence.concatenate(block.getSequence());
    return sequence;
  }

}
