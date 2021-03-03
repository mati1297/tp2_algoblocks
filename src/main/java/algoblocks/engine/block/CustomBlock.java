package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import java.util.ArrayList;

public class CustomBlock extends EffectBlock {

  public CustomBlock() {
    super();
  }

  public CustomBlock(String name) {
    super(name);
  }

  public CustomBlock(String name, ArrayList<Block> blocks) {
    super(name);
    this.blocks.addAll(blocks);
  }

  public CustomBlock(ArrayList<Block> blocks) {
    super("");
    this.blocks.addAll(blocks);
  }

  public void setName(String name) {
    blockName = name;
  }

  public EffectBlock makeCopy() {
    EffectBlock newBlock = new CustomBlock();
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
