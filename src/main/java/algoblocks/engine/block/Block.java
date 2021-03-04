package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

public abstract class Block {
    protected String blockName;

    public Block(String name){
        this.blockName = name;
    }

    public Block(){
        blockName = "";
    }

    @Override
    public boolean equals(Object object){
        return !(object == null || getClass() != object.getClass());
    }

    public String getBlockName(){
        return blockName;
    }

    public abstract Sequence getSequence();
    public abstract Sequence getInvertedSequence();
}