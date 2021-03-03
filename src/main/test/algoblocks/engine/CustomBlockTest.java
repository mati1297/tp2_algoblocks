package algoblocks.engine;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomBlockTest {

    @Test
    public void customBlockConstructorAndSetNameWorkOk(){
        CustomBlock custom = new CustomBlock("Custom block 1");

        assertEquals(custom.getBlockName(), "Custom block 1");

        custom.setName("Custom block 2");

        assertEquals(custom.getBlockName(), "Custom block 2");

    }

    @Test
    public void CustomBlockInvertedWithMoveUpAndMoveLeftActionsReturnSequenceWithThatActionsInverted(){
        ActionBlock moveUpBlock = new MoveUpBlock();
        ActionBlock moveLeftBlock = new MoveLeftBlock();

        CustomBlock customBlock = new CustomBlock();
        customBlock.addBlock(moveUpBlock);
        customBlock.addBlock(moveLeftBlock);

        Sequence customSequence = customBlock.getInvertedSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(moveUpBlock.getInvertedSequence());
        testSequence.concatenate(moveLeftBlock.getInvertedSequence());

        assertTrue(customSequence.equals(testSequence));
    }

    @Test
    public void customBlockWithMoveUpAndMoveLeftActionsReturnSequenceWithThatActions(){
        ActionBlock moveUpBlock = new MoveUpBlock();
        ActionBlock moveLeftBlock = new MoveLeftBlock();

        CustomBlock customBlock = new CustomBlock();
        customBlock.addBlock(moveUpBlock);
        customBlock.addBlock(moveLeftBlock);

        Sequence customSequence = customBlock.getSequence();
        Sequence testSequence = new Sequence();
        testSequence.concatenate(moveUpBlock.getSequence());
        testSequence.concatenate(moveLeftBlock.getSequence());

        assertTrue(customSequence.equals(testSequence));
    }

}
