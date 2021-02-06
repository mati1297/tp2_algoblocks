package algoblocks.engine;

public interface Block {
    public abstract Sequence getSequence();
    public abstract Sequence getInvertedSequence();
}