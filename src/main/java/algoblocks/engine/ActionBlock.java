package algoblocks.engine;

public interface ActionBlock extends Block {
    public Sequence getSequence();
    public Sequence getInvertedSequence();
}