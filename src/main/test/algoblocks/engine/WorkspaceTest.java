package algoblocks.engine;

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