package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import java.util.ArrayList;

public class CustomBlock extends Block {
  private ArrayList<Block> blocks;
  private String blockName;

  public CustomBlock(){
    blockName = "Custom";
    blocks = new ArrayList<Block>();
  }

  public CustomBlock(String name){
    blockName = name;
    blocks = new ArrayList<Block>();
  }

  public CustomBlock(String name, ArrayList<Block> blocks){
    blockName = name;
    this.blocks = new ArrayList<Block>();
    this.blocks.addAll(blocks);
  }

  public CustomBlock(ArrayList<Block> blocks){
    blockName = "Custom";
    this.blocks = new ArrayList<Block>();
    this.blocks.addAll(blocks);
  }

  public void setName(String name){
    blockName = name;
  }

  public CustomBlock makeCopy(){
    CustomBlock newBlock = new CustomBlock();
    newBlock.blockName = blockName;
    blocks.forEach((Block block) -> {
      if(block instanceof CustomBlock){
        CustomBlock otherBlock = (CustomBlock) block;
        newBlock.blocks.add(otherBlock.makeCopy());
      }
      else if(block instanceof EffectBlock){
        EffectBlock otherBlock = (EffectBlock) block;
        newBlock.blocks.add(otherBlock.makeCopy());
      }
      else
        newBlock.blocks.add(block);
    });
    return newBlock;
  }

  public void addBlock(Block block){
    blocks.add(block);
  }

  @Override
  public String getBlockName() {
    return blockName;
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
