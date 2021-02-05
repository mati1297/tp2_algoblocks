package algoblocks.engine;

public class MoveDownBlock implements ActionBlock {
  public Sequence getSequence() {
    return new Sequence(new MoveDownAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new MoveUpAction());
  }
}
