package algoblocks.engine;

import algoblocks.engine.action.*;
import algoblocks.engine.block.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActionBlockTest {
    @Test
    public void actionBlockIsCreatedWithCorrectName() {
        MoveDownBlock block = new MoveDownBlock();

        assertEquals(block.getBlockName(), BlockNames.MOVE_DOWN);
    }

    @Test
    public void moveUpBlockReturnsSequenceWithMoveUpAction() {
        ActionBlock block = new MoveUpBlock();

        Sequence sequence = block.getSequence();

        assertTrue(sequence.get(0) instanceof MoveUpAction);
    }

    @Test
    public void moveUpBlockReturnsInverseSequenceWithMoveDownAction() {
        ActionBlock block = new MoveUpBlock();

        Sequence sequence = block.getInvertedSequence();

        assertTrue(sequence.get(0) instanceof MoveDownAction);
    }

    @Test
    public void moveDownBlockReturnsSequenceWithMoveDownAction() {
        ActionBlock block = new MoveDownBlock();

        Sequence sequence = block.getSequence();

        assertTrue(sequence.get(0) instanceof MoveDownAction);
    }

    @Test
    public void moveDownBlockReturnsInverseSequenceWithMoveUpAction() {
        ActionBlock block = new MoveDownBlock();

        Sequence sequence = block.getInvertedSequence();

        assertTrue(sequence.get(0) instanceof MoveUpAction);
    }

    @Test
    public void moveRightBlockReturnsSequenceWithMoveRightAction() {
        ActionBlock block = new MoveRightBlock();

        Sequence sequence = block.getSequence();

        assertTrue(sequence.get(0) instanceof MoveRightAction);
    }

    @Test
    public void moveRightBlockReturnsInverseSequenceWithMoveLeftAction() {
        ActionBlock block = new MoveRightBlock();

        Sequence sequence = block.getInvertedSequence();

        assertTrue(sequence.get(0) instanceof MoveLeftAction);
    }

    @Test
    public void moveLeftBlockReturnsSequenceWithMoveLeftAction() {
        ActionBlock block = new MoveLeftBlock();

        Sequence sequence = block.getSequence();

        assertTrue(sequence.get(0) instanceof MoveLeftAction);
    }

    @Test
    public void moveLeftBlockReturnsInverseSequenceWithMoveRightAction() {
        ActionBlock block = new MoveLeftBlock();

        Sequence sequence = block.getInvertedSequence();

        assertTrue(sequence.get(0) instanceof MoveRightAction);
    }

    @Test
    public void raisePencilBlockReturnsSequenceWithRaisePencilAction() {
        ActionBlock block = new RaisePencilBlock();

        Sequence sequence = block.getSequence();

        assertTrue(sequence.get(0) instanceof RaisePencilAction);
    }

    @Test
    public void raisePencilBlockReturnsInvertedSequenceWithLowerPencilAction() {
        ActionBlock block = new RaisePencilBlock();

        Sequence sequence = block.getInvertedSequence();

        assertTrue(sequence.get(0) instanceof LowerPencilAction);
    }

    @Test
    public void lowerPencilBlockReturnsSequenceWithLowerPencilAction() {
        ActionBlock block = new LowerPencilBlock();

        Sequence sequence = block.getSequence();

        assertTrue(sequence.get(0) instanceof LowerPencilAction);
    }

    @Test
    public void lowerPencilBlockReturnsInvertedSequenceWithRaisePencilAction() {
        ActionBlock block = new LowerPencilBlock();

        Sequence sequence = block.getInvertedSequence();

        assertTrue(sequence.get(0) instanceof RaisePencilAction);
    }

    @Test
    public void twoDifferentActionBlocksAreDifferent() {
        ActionBlock blockOne = new LowerPencilBlock();
        ActionBlock blockTwo = new MoveDownBlock();

        assertFalse(blockOne.equals(blockTwo));
    }

    @Test
    public void twoEqualActionBlocksAreEqual() {
        ActionBlock blockOne = new LowerPencilBlock();
        ActionBlock blockTwo = new LowerPencilBlock();

        assertTrue(blockOne.equals(blockTwo));
    }

    @Test
    public void actionBlockIsDifferentToAnotherObject() {
        ActionBlock block = new LowerPencilBlock();
        Integer integer = 3;

        assertFalse(block.equals(integer));
    }

    @Test
    public void actionBlockIsDifferentToNull() {
        ActionBlock block = new LowerPencilBlock();

        assertFalse(block.equals(null));
    }

    @Test
    public void lowerPencilBlockCopyConstructorWorksOk(){
        LowerPencilBlock block = new LowerPencilBlock();

        LowerPencilBlock blockTest = new LowerPencilBlock(block);

        assertEquals(block, blockTest);
        assertFalse(block == blockTest);
    }

    @Test
    public void raisePencilBlockCopyConstructorWorksOk(){
        RaisePencilBlock block = new RaisePencilBlock();

        RaisePencilBlock blockTest = new RaisePencilBlock(block);

        assertEquals(block, blockTest);
        assertFalse(block == blockTest);
    }

    @Test
    public void moveDownBlockCopyConstructorWorksOk(){
        MoveDownBlock block = new MoveDownBlock();

        MoveDownBlock blockTest = new MoveDownBlock(block);

        assertEquals(block, blockTest);
        assertFalse(block == blockTest);
    }

    @Test
    public void moveUpBlockCopyConstructorWorksOk(){
        MoveUpBlock block = new MoveUpBlock();

        MoveUpBlock blockTest = new MoveUpBlock(block);

        assertEquals(block, blockTest);
        assertFalse(block == blockTest);
    }
    @Test
    public void moveLeftBlockCopyConstructorWorksOk(){
        MoveLeftBlock block = new MoveLeftBlock();

        MoveLeftBlock blockTest = new MoveLeftBlock(block);

        assertEquals(block, blockTest);
        assertFalse(block == blockTest);
    }

    @Test
    public void moveRightBlockCopyConstructorWorksOk(){
        MoveRightBlock block = new MoveRightBlock();

        MoveRightBlock blockTest = new MoveRightBlock(block);

        assertEquals(block, blockTest);
        assertFalse(block == blockTest);
    }

    
}