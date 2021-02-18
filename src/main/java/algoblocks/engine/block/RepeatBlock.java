package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import java.util.stream.IntStream;

public class RepeatBlock extends EffectBlock {

  private int times;

  public RepeatBlock(int times){
    super();
    this.times = 2;
    if(times >= 2)
      this.times = times;
  }

  public Sequence getSequence() {
    Sequence sequence = new Sequence();
    IntStream.rangeClosed(1, times).forEach((int i) -> {
      blocks.forEach((Block block) -> {
        sequence.concatenate(block.getSequence());
      });
    });
    return sequence;
  }

  public Sequence getInvertedSequence() {
    Sequence sequence = new Sequence();
    IntStream.rangeClosed(1, times).forEach((int i) -> {
      blocks.forEach((Block block) -> {
        sequence.concatenate(block.getInvertedSequence());
      });
    });
    return sequence;
  }
}
