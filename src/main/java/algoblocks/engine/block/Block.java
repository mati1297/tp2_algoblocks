package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

public abstract class Block {

    public Block(){

    }

    @Override
    public boolean equals(Object object){
        return !(object == null || getClass() != object.getClass());
    }

    public abstract String getBlockName();
    public abstract Sequence getSequence();
    public abstract Sequence getInvertedSequence();
}