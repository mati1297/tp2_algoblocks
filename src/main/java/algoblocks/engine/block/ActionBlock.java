package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

public abstract class ActionBlock extends Block {
    public ActionBlock() {
        super();
    };

    public abstract String getBlockName();
    public abstract Sequence getSequence();
    public abstract Sequence getInvertedSequence();
}