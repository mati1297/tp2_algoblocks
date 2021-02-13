package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

public interface Block {
    public abstract Sequence getSequence();
    public abstract Sequence getInvertedSequence();
}