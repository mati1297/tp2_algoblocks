package algoblocks.engine;

public class RepeatBlock extends EffectBlock{

  private int times;

  public RepeatBlock(int times){
    super();
    this.times = 2;
    if(times >= 2)
      this.times = times;
  }

  public Sequence getSequence() {
    Sequence sequence = new Sequence();
    for(int i = 0; i < times; i++){
      for(Block block: blocks)
        sequence.concatenate(block.getSequence());
    }
    return sequence;
  }

  public Sequence getInvertedSequence() {
    Sequence sequence = new Sequence();
    for(int i = 0; i < times; i++){
      for(Block block: blocks)
        sequence.concatenate(block.getInvertedSequence());
    }
    return sequence;
  }
}
