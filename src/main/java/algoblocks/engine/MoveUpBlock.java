package algoblocks.engine;

public class MoveUpBlock implements ActionBlock {
  public Sequence getSequence() {
    return new Sequence(new MoveUpAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new MoveDownAction());
  }
}
