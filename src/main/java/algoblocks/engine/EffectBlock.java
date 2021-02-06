package algoblocks.engine;

import java.util.ArrayList;

public abstract class EffectBlock implements Block {
    protected ArrayList<Block> blocks;

    public EffectBlock(){
        blocks = new ArrayList<Block>();
    }

    public void addBlock(Block block){
        blocks.add(block);
    }
    public abstract Sequence getSequence();
    public abstract Sequence getInvertedSequence();
}