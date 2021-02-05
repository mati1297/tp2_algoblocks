package algoblocks.engine;

public class RaisePencilBlock implements ActionBlock {
  public Sequence getSequence() {
    return new Sequence(new RaisePencilAction());
  }

  public Sequence getInvertedSequence() {
    return new Sequence(new LowerPencilAction());
  }
}
