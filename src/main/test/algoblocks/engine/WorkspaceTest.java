package algoblocks.engine;

import algoblocks.engine.action.*;
import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkspaceTest {
    @Test
    public void AddBlockAndCompileWorkspaceReturnSequenceWithAction() {
        Workspace workspace = new Workspace();

        workspace.addBlock(new MoveUpBlock());

        Sequence sequence = workspace.compile();

        assertTrue(sequence.get(0) instanceof MoveUpAction);
    }

    @Test
    public void DeleteBlockAndCompileWorkspaceReturnsSequenceWithoutThatAction() {
        Workspace workspace = new Workspace();

        workspace.addBlock(new MoveUpBlock());
        workspace.addBlock(new MoveDownBlock());

        workspace.deleteBlock(1);

        Sequence testSequence = workspace.compile();

        Sequence referenceSequence = new Sequence(new MoveUpAction());

        assertTrue(testSequence.equals(referenceSequence));
    }

    @Test
    public void clearingAWorkspaceAndCompilingReturnsAnEmptySequence() {
        Workspace workspace = new Workspace();

        workspace.addBlock(new MoveUpBlock());

        workspace.clear();

        Sequence testSequence = workspace.compile();

        Sequence referenceSequence = new Sequence();

        assertTrue(testSequence.equals(referenceSequence));
    }

    @Test
    public void creatingACustomBlockAndAddingItToWorkspaceAndCompilingReturnsCorrectSequence() {
        Workspace workspaceOne = new Workspace();
        Workspace workspaceTwo = new Workspace();

        workspaceOne.addBlock(new MoveUpBlock());
        CustomBlock custom = workspaceOne.createCustomBlock();
        workspaceTwo.addBlock(custom);

        assertTrue(workspaceOne.compile().equals(workspaceTwo.compile()));
    }

}