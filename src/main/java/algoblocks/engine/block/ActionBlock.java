package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

public abstract class ActionBlock extends Block {

    public ActionBlock(String name) {
        super(name);
    };

    public ActionBlock(ActionBlock original){
        super(original);
    }

    public abstract Sequence getSequence();
    public abstract Sequence getInvertedSequence();
}