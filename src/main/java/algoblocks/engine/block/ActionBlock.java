package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

public interface ActionBlock extends Block {
    public Sequence getSequence();
    public Sequence getInvertedSequence();
}