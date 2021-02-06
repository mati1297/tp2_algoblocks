package algoblocks.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EffectBlockTest {
    @Test
    public void RepeatTwoTimesBlockWithMoveUpAndMoveLeftActionsReturnSequenceWithThatActions(){
        ActionBlock moveUpBlock = new MoveUpBlock();
        ActionBlock moveLeftBlock = new MoveLeftBlock();

        EffectBlock repeatTwoTimesBlock = new RepeatTwoTimesBlock();
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

        EffectBlock repeatTwoTimesBlock = new RepeatTwoTimesBlock();
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

        EffectBlock repeatThreeTimesBlock = new RepeatThreeTimesBlock();
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

        EffectBlock repeatThreeTimesBlock = new RepeatThreeTimesBlock();
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
}