package algoblocks.engine;

public class LowerPencilBlock implements ActionBlock {
  public Sequence getSequence() {
    return new Sequence(new LowerPencilAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new RaisePencilAction());
  }
}
