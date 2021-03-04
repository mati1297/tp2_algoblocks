package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public abstract class EffectBlock extends Block {
    protected ArrayList<Block> blocks;

    public EffectBlock(String name) {
        super(name);
        blocks = new ArrayList<Block>();
    }

    public EffectBlock() {
        super();
        blocks = new ArrayList<Block>();
    }

    public EffectBlock(EffectBlock original){
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

    public void addBlock(Block block){
        blocks.add(block);
    }

    @Override
    public boolean equals(Object object) {
        if(super.equals(object) == false)
            return false;

        EffectBlock otherBlock = (EffectBlock) object;

        if(!blocks.equals(otherBlock.blocks))
            return false;

        return true;
    }

    public abstract Sequence getSequence();
    public abstract Sequence getInvertedSequence();
}