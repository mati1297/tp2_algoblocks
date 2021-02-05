package algoblocks.engine;

public class MoveRightBlock implements ActionBlock {
  public Sequence getSequence() {
    return new Sequence(new MoveRightAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new MoveLeftAction());
  }
}
