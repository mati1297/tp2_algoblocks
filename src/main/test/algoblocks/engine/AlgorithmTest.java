package algoblocks.engine;

import algoblocks.engine.action.MoveUpAction;
import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.MoveDownBlock;
import algoblocks.engine.block.MoveUpBlock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmTest {
    @Test
    public void AddBlockAndCompileAlgorithmReturnSequenceWithAction(){
        Algorithm algorithm = new Algorithm();

        algorithm.addBlock(new MoveUpBlock());

        Sequence sequence = algorithm.compile();

        assertTrue(sequence.get(0) instanceof MoveUpAction);
    }

    @Test
    public void RemoveBlockFromAlgorithm() {
        Algorithm algorithm = new Algorithm();

        algorithm.addBlock(new MoveUpBlock());
        algorithm.addBlock(new MoveDownBlock());

        algorithm.deleteBlock(1);

        Algorithm expectedAlgorithm = new Algorithm();
        expectedAlgorithm.addBlock(new MoveUpBlock());

        assertTrue(algorithm.equals(expectedAlgorithm));
    }

    @Test
    public void ClearAlgorithmDeletesAllBlocks() {
        Algorithm algorithm = new Algorithm();

        algorithm.addBlock(new MoveUpBlock());
        algorithm.addBlock(new MoveDownBlock());

        algorithm.clear();

        Algorithm expectedAlgorithm =  new Algorithm();

        assertTrue(algorithm.equals(expectedAlgorithm));
    }
    

    @Test
    public void algorithmIsDifferentToNull(){
        assertNotEquals(new Algorithm(), null);
    }

    @Test
    public void algorithmIsDifferentToOtherObject(){
        assertNotEquals(new Algorithm(), 5);
    }

    @Test
    public void algorithmsWithDifferentBlocksAreDifferent(){
        Algorithm algorithm = new Algorithm();
        Algorithm algorithm2 = new Algorithm();
        algorithm.addBlock(new MoveDownBlock());
        algorithm2.addBlock(new MoveUpBlock());

        assertNotEquals(algorithm, algorithm2);
    }

    @Test
    public void algorithmsWithDifferentCantOfBlocksAreDifferent(){
        Algorithm algorithm = new Algorithm();
        Algorithm algorithm2 = new Algorithm();
        algorithm.addBlock(new MoveDownBlock());

        assertNotEquals(algorithm, algorithm2);
    }
}