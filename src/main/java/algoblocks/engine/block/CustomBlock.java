package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import java.util.ArrayList;
import java.lang.reflect.Constructor;

public class CustomBlock extends Block {
  private ArrayList<Block> blocks;

  public CustomBlock(){
    super(BlockNames.CUSTOM_DEFAULT);
    blocks = new ArrayList<Block>();
  }

  public CustomBlock(String name){
    super(name);
    blocks = new ArrayList<Block>();
  }

  public CustomBlock(String name, ArrayList<Block> blocks){
    super(name);
    this.blocks = new ArrayList<Block>();
    this.blocks.addAll(blocks);
  }

  public CustomBlock(ArrayList<Block> blocks){
    super(BlockNames.CUSTOM_DEFAULT);
    this.blocks = new ArrayList<Block>();
    this.blocks.addAll(blocks);
  }

  public CustomBlock(CustomBlock original){
    super(original);
    blocks = new ArrayList<Block>();
    original.blocks.forEach((Block block) -> {
        Constructor<? extends Block> constructor = null;
        try{
            constructor = block.getClass().getDeclaredConstructor(block.getClass());      
        }
        catch(Exception e) {
            System.out.println(e.toString());
         }
        try{
            blocks.add(constructor.newInstance(block));
        }
        catch(Exception e){System.out.println(e);}  
        
    });
  }


  public void setName(String name) {
    this.name = name;
  }

  public void addBlock(Block block){
    blocks.add(block);
  }

  @Override
  public String getName() {
    return name;
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
