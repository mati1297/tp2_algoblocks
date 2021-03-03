package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

public abstract class Block {
    protected String blockName;

    public Block(String name) {
        blockName = name;
    }

    public Block() {
        blockName = "";
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass())
            return false;

        Block otherBlock = (Block) object;

        if (!blockName.equals(otherBlock.blockName))
            return false;
        
        return true;
    }

    public String getBlockName() {
        return blockName;
    }

    public abstract Sequence getSequence();
    public abstract Sequence getInvertedSequence();
}