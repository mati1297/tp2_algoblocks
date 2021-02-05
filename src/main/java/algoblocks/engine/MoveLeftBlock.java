package algoblocks.engine;

public class MoveLeftBlock implements ActionBlock {
  public Sequence getSequence() {
    return new Sequence(new MoveLeftAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new MoveRightAction());
  }
}
