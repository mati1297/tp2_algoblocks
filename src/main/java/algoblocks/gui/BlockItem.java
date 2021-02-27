package algoblocks.gui;

import algoblocks.engine.block.*;

public class BlockItem{
    protected Block block;

    public BlockItem(Block block){
        this.block = block;
    }

    @Override
    public String toString(){
        return block.getBlockName();
    }
}