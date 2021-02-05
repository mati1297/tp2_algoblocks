package algoblocks.engine;

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