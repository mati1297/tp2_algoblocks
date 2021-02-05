package algoblocks.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActionBlockTest {
    @Test
    public void MoveUpBlockReturnsSequenceWithMoveUpAction(){
        ActionBlock block = new MoveUpBlock();

        Sequence sequence = block.getSequence();

        assertTrue(sequence.get(0) instanceof MoveUpAction);
    }

    @Test
    public void MoveUpBlockReturnsInverseSequenceWithMoveDownAction(){
        ActionBlock block = new MoveUpBlock();

        Sequence sequence = block.getInvertedSequence();

        assertTrue(sequence.get(0) instanceof MoveDownAction);
    }

    @Test
    public void MoveDownBlockReturnsSequenceWithMoveDownAction(){
        ActionBlock block = new MoveDownBlock();

        Sequence sequence = block.getSequence();

        assertTrue(sequence.get(0) instanceof MoveDownAction);
    }

    @Test
    public void MoveDownBlockReturnsInverseSequenceWithMoveUpAction(){
        ActionBlock block = new MoveDownBlock();

        Sequence sequence = block.getInvertedSequence();

        assertTrue(sequence.get(0) instanceof MoveUpAction);
    }

    @Test
    public void MoveRightBlockReturnsSequenceWithMoveRightAction(){
        ActionBlock block = new MoveRightBlock();

        Sequence sequence = block.getSequence();

        assertTrue(sequence.get(0) instanceof MoveRightAction);
    }

    @Test
    public void MoveRightBlockReturnsInverseSequenceWithMoveLeftAction(){
        ActionBlock block = new MoveRightBlock();

        Sequence sequence = block.getInvertedSequence();

        assertTrue(sequence.get(0) instanceof MoveLeftAction);
    }

    @Test
    public void MoveLeftBlockReturnsSequenceWithMoveLeftAction(){
        ActionBlock block = new MoveLeftBlock();

        Sequence sequence = block.getSequence();

        assertTrue(sequence.get(0) instanceof MoveLeftAction);
    }

    @Test
    public void MoveLeftBlockReturnsInverseSequenceWithMoveRightAction(){
        ActionBlock block = new MoveLeftBlock();

        Sequence sequence = block.getInvertedSequence();

        assertTrue(sequence.get(0) instanceof MoveRightAction);
    }

    @Test
    public void RaisePencilBlockReturnsSequenceWithRaisePencilAction(){
        ActionBlock block = new RaisePencilBlock();

        Sequence sequence = block.getSequence();

        assertTrue(sequence.get(0) instanceof RaisePencilAction);
    }

    @Test
    public void RaisePencilBlockReturnsInvertedSequenceWithLowerPencilAction(){
        ActionBlock block = new RaisePencilBlock();

        Sequence sequence = block.getInvertedSequence();

        assertTrue(sequence.get(0) instanceof LowerPencilAction);
    }

    @Test
    public void LowerPencilBlockReturnsSequenceWithLowerPencilAction(){
        ActionBlock block = new LowerPencilBlock();

        Sequence sequence = block.getSequence();

        assertTrue(sequence.get(0) instanceof LowerPencilAction);
    }

    @Test
    public void LowerPencilBlockReturnsInvertedSequenceWithRaisePencilAction(){
        ActionBlock block = new LowerPencilBlock();

        Sequence sequence = block.getInvertedSequence();

        assertTrue(sequence.get(0) instanceof RaisePencilAction);
    }
}