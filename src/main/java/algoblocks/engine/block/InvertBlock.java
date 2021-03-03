package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

public class InvertBlock extends EffectBlock {

  public InvertBlock() {
    super("Invert");
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

  public EffectBlock makeCopy() {
    EffectBlock newBlock = new InvertBlock();
    newBlock.blockName = blockName;
    blocks.forEach((Block block) -> {
      if(block instanceof EffectBlock) {
        EffectBlock otherBlock = (EffectBlock) block;
        newBlock.blocks.add(otherBlock.makeCopy());
      }
      else
        newBlock.blocks.add(block);
    });
    return newBlock;
  }
}
