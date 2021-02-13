package algoblocks.engine;

import algoblocks.engine.action.MoveUpAction;
import algoblocks.engine.action.Sequence;
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
    
}