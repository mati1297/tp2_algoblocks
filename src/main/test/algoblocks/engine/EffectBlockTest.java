package algoblocks.engine;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EffectBlockTest {
    @Test
    public void RepeatTwoTimesBlockWithMoveUpAndMoveLeftActionsReturnSequenceWithThatActions(){
        ActionBlock moveUpBlock = new MoveUpBlock();
        ActionBlock moveLeftBlock = new MoveLeftBlock();

        EffectBlock repeatTwoTimesBlock = new RepeatBlock(2);
        repeatTwoTimesBlock.addBlock(moveUpBlock);
        repeatTwoTimesBlock.addBlock(moveLeftBlock);

        Sequence repeatSequence = repeatTwoTimesBlock.getSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(moveUpBlock.getSequence());
        testSequence.concatenate(moveLeftBlock.getSequence());
        testSequence.concatenate(moveUpBlock.getSequence());
        testSequence.concatenate(moveLeftBlock.getSequence());

        assertTrue(repeatSequence.equals(testSequence));
    }


    @Test
    public void RepeatTwoTimesBlockInvertedWithMoveUpAndMoveLeftActionsReturnSequenceWithThatActionsInverted(){
        ActionBlock moveUpBlock = new MoveUpBlock();
        ActionBlock moveLeftBlock = new MoveLeftBlock();

        EffectBlock repeatTwoTimesBlock = new RepeatBlock(2);
        repeatTwoTimesBlock.addBlock(moveUpBlock);
        repeatTwoTimesBlock.addBlock(moveLeftBlock);

        Sequence repeatSequence = repeatTwoTimesBlock.getInvertedSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(moveUpBlock.getInvertedSequence());
        testSequence.concatenate(moveLeftBlock.getInvertedSequence());
        testSequence.concatenate(moveUpBlock.getInvertedSequence());
        testSequence.concatenate(moveLeftBlock.getInvertedSequence());

        assertTrue(repeatSequence.equals(testSequence));
    }


    @Test
    public void RepeatThreeTimesBlockWithMoveUpAndMoveLeftActionsReturnSequenceWithThatActions(){
        ActionBlock moveUpBlock = new MoveUpBlock();
        ActionBlock moveLeftBlock = new MoveLeftBlock();

        EffectBlock repeatThreeTimesBlock = new RepeatBlock(3);
        repeatThreeTimesBlock.addBlock(moveUpBlock);
        repeatThreeTimesBlock.addBlock(moveLeftBlock);

        Sequence repeatSequence = repeatThreeTimesBlock.getSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(moveUpBlock.getSequence());
        testSequence.concatenate(moveLeftBlock.getSequence());
        testSequence.concatenate(moveUpBlock.getSequence());
        testSequence.concatenate(moveLeftBlock.getSequence());
        testSequence.concatenate(moveUpBlock.getSequence());
        testSequence.concatenate(moveLeftBlock.getSequence());

        assertTrue(repeatSequence.equals(testSequence));
    }

    @Test
    public void RepeatThreeTimesBlockInvertedWithMoveUpMoveLeftAndActionsReturnSequenceWithThatActionsInverted(){
        ActionBlock moveUpBlock = new MoveUpBlock();
        ActionBlock moveLeftBlock = new MoveLeftBlock();

        EffectBlock repeatThreeTimesBlock = new RepeatBlock(3);
        repeatThreeTimesBlock.addBlock(moveUpBlock);
        repeatThreeTimesBlock.addBlock(moveLeftBlock);

        Sequence repeatSequence = repeatThreeTimesBlock.getInvertedSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(moveUpBlock.getInvertedSequence());
        testSequence.concatenate(moveLeftBlock.getInvertedSequence());
        testSequence.concatenate(moveUpBlock.getInvertedSequence());
        testSequence.concatenate(moveLeftBlock.getInvertedSequence());
        testSequence.concatenate(moveUpBlock.getInvertedSequence());
        testSequence.concatenate(moveLeftBlock.getInvertedSequence());

        assertTrue(repeatSequence.equals(testSequence));
    }

    @Test
    public void RepeatingTwoTimesAThreeTimesBlockRepeatItsActionSixTimes(){
        ActionBlock moveDownBlock = new MoveDownBlock();

        EffectBlock repeatThreeTimes = new RepeatBlock(3);
        EffectBlock repeatTwoTimes = new RepeatBlock(2);

        repeatThreeTimes.addBlock(moveDownBlock);
        repeatTwoTimes.addBlock(repeatThreeTimes);
        
        Sequence repeatSequence = repeatTwoTimes.getSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(moveDownBlock.getSequence());
        testSequence.concatenate(moveDownBlock.getSequence());
        testSequence.concatenate(moveDownBlock.getSequence());
        testSequence.concatenate(moveDownBlock.getSequence());
        testSequence.concatenate(moveDownBlock.getSequence());
        testSequence.concatenate(moveDownBlock.getSequence());

        assertTrue(repeatSequence.equals(testSequence));
    }

    @Test
    public void CreateARepeatBlockWithLessThan2TimesCreatesADefaultRepeatBlock(){
        ActionBlock moveUpBlock = new MoveUpBlock();
        ActionBlock moveLeftBlock = new MoveLeftBlock();

        EffectBlock repeatTwoTimesBlock = new RepeatBlock(0);
        repeatTwoTimesBlock.addBlock(moveUpBlock);
        repeatTwoTimesBlock.addBlock(moveLeftBlock);

        Sequence repeatSequence = repeatTwoTimesBlock.getSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(moveUpBlock.getSequence());
        testSequence.concatenate(moveLeftBlock.getSequence());
        testSequence.concatenate(moveUpBlock.getSequence());
        testSequence.concatenate(moveLeftBlock.getSequence());

        assertTrue(repeatSequence.equals(testSequence));
    }

    @Test
    public void InvertBlockWithRaisePencilReturnSequenceWithLowerPencil(){
        ActionBlock raisePencilBlock = new RaisePencilBlock();

        EffectBlock invertBlock = new InvertBlock();
        invertBlock.addBlock(raisePencilBlock);

        Sequence invertedSequence = invertBlock.getSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(raisePencilBlock.getInvertedSequence());

        assertTrue(invertedSequence.equals(testSequence));

    }

    @Test
    public void InvertBlockWithRaisePencilReturnInvertedSequenceWithRaisePencil(){
        ActionBlock raisePencilBlock = new RaisePencilBlock();

        EffectBlock invertBlock = new InvertBlock();
        invertBlock.addBlock(raisePencilBlock);

        Sequence invertedSequence = invertBlock.getInvertedSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(raisePencilBlock.getSequence());

        assertTrue(invertedSequence.equals(testSequence));

    }


    @Test
    public void InvertingAnInvertBlockReturnOriginalAction(){
        ActionBlock raisePencilBlock = new RaisePencilBlock();

        EffectBlock invertBlockOne = new InvertBlock();
        EffectBlock invertBlockTwo = new InvertBlock();
        invertBlockOne.addBlock(raisePencilBlock);
        invertBlockTwo.addBlock(invertBlockOne);

        Sequence doubleInvertedSequence = invertBlockTwo.getSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(raisePencilBlock.getSequence());

        assertTrue(doubleInvertedSequence.equals(testSequence));
    }

    @Test
    public void CustomBlockWithMoveUpAndMoveLeftActionsReturnSequenceWithThatActions(){
        ActionBlock moveUpBlock = new MoveUpBlock();
        ActionBlock moveLeftBlock = new MoveLeftBlock();

        EffectBlock customBlock = new CustomBlock();
        customBlock.addBlock(moveUpBlock);
        customBlock.addBlock(moveLeftBlock);

        Sequence customSequence = customBlock.getSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(moveUpBlock.getSequence());
        testSequence.concatenate(moveLeftBlock.getSequence());

        assertTrue(customSequence.equals(testSequence));
    }


    @Test
    public void CustomBlockInvertedWithMoveUpAndMoveLeftActionsReturnSequenceWithThatActionsInverted(){
        ActionBlock moveUpBlock = new MoveUpBlock();
        ActionBlock moveLeftBlock = new MoveLeftBlock();

        EffectBlock customBlock = new CustomBlock();
        customBlock.addBlock(moveUpBlock);
        customBlock.addBlock(moveLeftBlock);

        Sequence customSequence = customBlock.getInvertedSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(moveUpBlock.getInvertedSequence());
        testSequence.concatenate(moveLeftBlock.getInvertedSequence());

        assertTrue(customSequence.equals(testSequence));
    }

}