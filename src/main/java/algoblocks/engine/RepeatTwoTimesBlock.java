package algoblocks.engine;

public class RepeatTwoTimesBlock extends EffectBlock{

  public RepeatTwoTimesBlock(){
    super();
  }

  public Sequence getSequence() {
    Sequence sequence = new Sequence();
    for(int i = 0; i < 2; i++){
      for(Block block: blocks)
        sequence.concatenate(block.getSequence());
    }
    return sequence;
  }

  public Sequence getInvertedSequence() {
    Sequence sequence = new Sequence();
    for(int i = 0; i < 2; i++){
      for(Block block: blocks)
        sequence.concatenate(block.getInvertedSequence());
    }
    return sequence;
  }
}
