package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

public class CustomBlock extends EffectBlock {

  public CustomBlock(){
    super();
  }

  public CustomBlock(String name){
    super(name);
  }

  public void setName(String name){
    blockName = name;
  }

  public Sequence getSequence() {
    Sequence sequence = new Sequence();
    for(Block block: blocks)
      sequence.concatenate(block.getSequence());
    return sequence;
  }

  public Sequence getInvertedSequence() {
    Sequence sequence = new Sequence();
    for(Block block: blocks)
      sequence.concatenate(block.getInvertedSequence());
    return sequence;
  }
}
