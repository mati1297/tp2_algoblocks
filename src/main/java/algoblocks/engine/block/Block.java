package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

public abstract class Block {
    private String blockName;

    public Block(String name) {
        blockName = name;
    }

    public Block() {
        blockName = "";
    }

    public String getBlockName() {
        return blockName;
    }

    public abstract Sequence getSequence();
    public abstract Sequence getInvertedSequence();
}