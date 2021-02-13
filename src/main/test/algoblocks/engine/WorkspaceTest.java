package algoblocks.engine;

import algoblocks.engine.action.MoveUpAction;
import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.MoveUpBlock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkspaceTest {
    @Test
    public void AddBlockAndCompileWorkspaceReturnSequenceWithAction(){
        Workspace workspace = new Workspace();

        workspace.addBlock(new MoveUpBlock());

        Sequence sequence = workspace.compile();

        assertTrue(sequence.get(0) instanceof MoveUpAction);
    }
}