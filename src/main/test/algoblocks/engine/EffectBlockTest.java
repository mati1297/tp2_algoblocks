package algoblocks.engine;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EffectBlockTest {
    @Test
    public void repeatTwoTimesBlockWithMoveUpAndMoveLeftActionsReturnSequenceWithThatActions() {
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
    public void repeatTwoTimesBlockInvertedWithMoveUpAndMoveLeftActionsReturnSequenceWithThatActionsInverted() {
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
    public void repeatThreeTimesBlockWithMoveUpAndMoveLeftActionsReturnSequenceWithThatActions() {
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
    public void repeatThreeTimesBlockInvertedWithMoveUpMoveLeftAndActionsReturnSequenceWithThatActionsInverted() {
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
    public void repeatingTwoTimesAThreeTimesBlockRepeatItsActionSixTimes() {
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
    public void createARepeatBlockWithLessThan2TimesCreatesADefaultRepeatBlock() {
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
    public void invertBlockWithRaisePencilReturnSequenceWithLowerPencil() {
        ActionBlock raisePencilBlock = new RaisePencilBlock();

        EffectBlock invertBlock = new InvertBlock();
        invertBlock.addBlock(raisePencilBlock);

        Sequence invertedSequence = invertBlock.getSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(raisePencilBlock.getInvertedSequence());

        assertTrue(invertedSequence.equals(testSequence));
    }

    @Test
    public void invertBlockWithRaisePencilReturnInvertedSequenceWithRaisePencil() {
        ActionBlock raisePencilBlock = new RaisePencilBlock();

        EffectBlock invertBlock = new InvertBlock();
        invertBlock.addBlock(raisePencilBlock);

        Sequence invertedSequence = invertBlock.getInvertedSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(raisePencilBlock.getSequence());

        assertTrue(invertedSequence.equals(testSequence));
    }

    @Test
    public void invertingAnInvertBlockReturnOriginalAction() {
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
    public void repeatBlockIsEqualToAnotherWithSameBlocksAndTimes() {
        Block moveUp = new MoveUpBlock();
        Block moveDown = new MoveDownBlock();

        EffectBlock repeatOne = new RepeatBlock(2);
        EffectBlock repeatTwo = new RepeatBlock(2);

        repeatOne.addBlock(moveUp);
        repeatOne.addBlock(moveDown);
        repeatTwo.addBlock(moveUp);
        repeatTwo.addBlock(moveDown);

        assertTrue(repeatOne.equals(repeatTwo));
    }

    @Test
    public void repeatBlockIsDifferentToAnotherWithSameBlocksButDifferentTimes() {
        Block moveUp = new MoveUpBlock();
        Block moveDown = new MoveDownBlock();

        RepeatBlock repeatOne = new RepeatBlock(2);
        RepeatBlock repeatTwo = new RepeatBlock(3);

        repeatOne.addBlock(moveUp);
        repeatOne.addBlock(moveDown);
        repeatTwo.addBlock(moveUp);
        repeatTwo.addBlock(moveDown);

        assertFalse(repeatOne.equals(repeatTwo));
    }

    @Test
    public void invertBlocksWithDifferentBlocksAreDifferent() {
        Block moveUp = new MoveUpBlock();
        Block moveDown = new MoveDownBlock();

        EffectBlock invertOne = new InvertBlock();
        EffectBlock invertTwo = new InvertBlock();

        invertOne.addBlock(moveUp);
        invertTwo.addBlock(moveDown);

        assertFalse(invertOne.equals(invertTwo));
    }

    @Test
    public void settingTimesInRepeatBlockWorksOk() {
        ActionBlock moveDownBlock = new MoveDownBlock();

        RepeatBlock repeat = new RepeatBlock(2);

        repeat.addBlock(moveDownBlock);

        repeat.setTimes(3);
        
        Sequence repeatSequence = repeat.getSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(moveDownBlock.getSequence());
        testSequence.concatenate(moveDownBlock.getSequence());
        testSequence.concatenate(moveDownBlock.getSequence());


        assertTrue(repeatSequence.equals(testSequence));
    }

    @Test
    public void settingARepeatBlockWithLessThanTwoTimesSetsATwoTimesBlock() {
        ActionBlock moveDownBlock = new MoveDownBlock();

        RepeatBlock repeat = new RepeatBlock(2);

        repeat.addBlock(moveDownBlock);

        repeat.setTimes(0);

        Sequence repeatSequence = repeat.getSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(moveDownBlock.getSequence());
        testSequence.concatenate(moveDownBlock.getSequence());

        assertTrue(repeatSequence.equals(testSequence));
    }

}