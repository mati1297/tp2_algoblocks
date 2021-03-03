package algoblocks.engine;

import algoblocks.engine.block.*;
import algoblocks.engine.grid.Coordinates;
import algoblocks.engine.grid.Size;
import algoblocks.engine.drawing.*;
import algoblocks.engine.player.Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void workspaceAddActionBlockAndExecuteInPlayer() {
        Game game = new Game();
        Block moveDown = new MoveDownBlock();

        game.addBlockToWorkspace(moveDown);
        
        Coordinates expectedCoordinates = new Coordinates(0, -1);

        game.run();

        Player playerInGame = game.getPlayer();
        
        assertEquals(expectedCoordinates, playerInGame.getPosition());
    }

    @Test
    public void workspaceAddRepeatBlockAndExecuteInPlayer() {
        Game game = new Game();
        EffectBlock repeatTwice = new RepeatBlock(4);
        Block moveUp = new MoveUpBlock();

        repeatTwice.addBlock(moveUp);
        game.addBlockToWorkspace(repeatTwice);

        Coordinates expectedCoordinates = new Coordinates(0, 4);

        game.run();

        Player playerInGame = game.getPlayer();
        
        assertEquals(expectedCoordinates, playerInGame.getPosition());
    }

    @Test
    public void workspaceAddInvertBlockAndExecuteInPlayer() {
        Game game = new Game();
        EffectBlock invert = new InvertBlock();
        Block moveUp = new MoveUpBlock();
        Block moveLeft = new MoveLeftBlock();

        invert.addBlock(moveUp);
        invert.addBlock(moveLeft);
        game.addBlockToWorkspace(invert);

        Coordinates expectedCoordinates = new Coordinates(1, -1);

        game.run();

        Player playerInGame = game.getPlayer();
        
        assertEquals(expectedCoordinates, playerInGame.getPosition());
    }

    @Test
    public void workspaceAddCustomBlockAndExecuteInPlayer() {
        Game game = new Game();
        CustomBlock custom = new CustomBlock();
        Block moveUp = new MoveUpBlock();
        Block moveDown = new MoveDownBlock();
        Block moveLeft = new MoveLeftBlock();

        custom.addBlock(moveUp);
        custom.addBlock(moveDown);
        custom.addBlock(moveLeft);
        game.addBlockToWorkspace(custom);

        Coordinates expectedCoordinates = new Coordinates(-1, 0);

        game.run();

        Player playerInGame = game.getPlayer();
        
        assertEquals(expectedCoordinates, playerInGame.getPosition());
    }

    @Test
    public void drawingCopyConstructorCopiesAnotherDrawing() {
        Drawing drawingOne = new Drawing();
        Coordinates coords = new Coordinates();
    
        drawingOne.addShape(new Line(coords, coords));
        drawingOne.addShape(new Blank(coords, coords));
        
        Drawing drawingTwo = new Drawing(drawingOne);
    
        assertTrue(drawingTwo.equals(drawingOne));
    }

    @Test
    public void createCustomBlockSavesWholeAlgorithm() {
        Game game = new Game();

        game.addBlockToWorkspace(new MoveUpBlock());
        game.addBlockToWorkspace(new MoveDownBlock());
        game.addBlockToWorkspace(new MoveLeftBlock());

        CustomBlock customBlock = game.createCustomBlock();

        CustomBlock expectedCustomBlock = new CustomBlock();
        expectedCustomBlock.addBlock(new MoveUpBlock());
        expectedCustomBlock.addBlock(new MoveDownBlock());
        expectedCustomBlock.addBlock(new MoveLeftBlock());
        
        assertTrue(customBlock.equals(expectedCustomBlock));
    }

    @Test
    public void getGridSizeReturnsDefautlSize() {
        Game game = new Game();

        Size size = game.getGridSize();
        Size expectedSize = new Size(10, 10);

        assertTrue(size.equals(expectedSize));
    }

    @Test
    public void getGridSizeReturnCorrectObject() {
        Game game = new Game();

        Size size = game.getGridSize();
        Size expectedSize = new Size(10, 50);

        assertFalse(size.equals(expectedSize));
    }

    @Test
    public void clearWorkspaceHasNoBlocks() {
        Game game = new Game();

        game.addBlockToWorkspace(new MoveUpBlock());
        game.addBlockToWorkspace(new MoveDownBlock());
        game.addBlockToWorkspace(new MoveLeftBlock());

        game.clearWorkspace();

        CustomBlock clearCustomBlock = game.createCustomBlock();

        assertTrue(clearCustomBlock.equals(new CustomBlock()));
    }

    @Test
    public void getDrawingReturnsExpectedDrawing() {
        Game game = new Game();

        game.addBlockToWorkspace(new LowerPencilBlock());
        game.addBlockToWorkspace(new MoveUpBlock());
        game.addBlockToWorkspace(new MoveDownBlock());
        game.addBlockToWorkspace(new MoveLeftBlock());

        game.run();

        Drawing drawing = game.getDrawing();

        Drawing expectedDrawing = new Drawing();
        expectedDrawing.addShape(new Line(new Coordinates(0, 0), new Coordinates(0, 1)));
        expectedDrawing.addShape(new Line(new Coordinates(0, 1), new Coordinates(0, 0)));
        expectedDrawing.addShape(new Line(new Coordinates(0, 0), new Coordinates(-1, 0)));

        assertTrue(drawing.equals(expectedDrawing));
    }

    @Test
    public void deleteBlockFromWorkspaceTakesOutTheCorrectBlock() {
        Game game = new Game();

        game.addBlockToWorkspace(new LowerPencilBlock());
        game.addBlockToWorkspace(new MoveUpBlock());
        game.addBlockToWorkspace(new MoveDownBlock());
        game.addBlockToWorkspace(new MoveLeftBlock());

        game.deleteBlockFromWorkspace(3);

        CustomBlock workspaceWithoutSelectedBlock = game.createCustomBlock();

        CustomBlock expectedWorkspace = new CustomBlock();
        expectedWorkspace.addBlock(new LowerPencilBlock());
        expectedWorkspace.addBlock(new MoveUpBlock());
        expectedWorkspace.addBlock(new MoveDownBlock());

        assertTrue(workspaceWithoutSelectedBlock.equals(expectedWorkspace));
    }
}