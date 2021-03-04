package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;
import java.util.stream.IntStream;

public class RepeatBlock extends EffectBlock {
  private int times;

  public RepeatBlock(int times) {
    this.times = 2;
    if(times >= 2)
      this.times = times;
    name = BlockNames.REPEAT_PART_ONE + " " + String.valueOf(times) + " " + BlockNames.REPEAT_PART_TWO;
  }

  public RepeatBlock(RepeatBlock original){
    super(original);
    this.times = original.times;
  }


  public void setTimes(int times) {
    if(times >= 2)
      this.times = times;
    name = "Repeat " + String.valueOf(times) + " times";
  }

  @Override
  public boolean equals(Object object){
    if(super.equals(object) == false)
      return false;

    RepeatBlock otherBlock = (RepeatBlock) object;

    if(!name.equals(otherBlock.name))
      return false;

    return true;
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
