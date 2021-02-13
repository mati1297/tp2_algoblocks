package algoblocks.engine;

import algoblocks.engine.block.*;
import algoblocks.engine.grid.Coordinates;
import algoblocks.engine.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void workspaceAddActionBlockAndExecuteInPlayer(){
        Game game = new Game();
        Block moveDown = new MoveDownBlock();

        game.addBlockToWorkspace(moveDown);
        
        Coordinates expectedCoordinates = new Coordinates(0, -1);

        game.run();

        Player playerInGame = game.getPlayer();
        
        assertEquals(expectedCoordinates, playerInGame.getPosition());
    }

    @Test
    public void workspaceAddRepeatBlockAndExecuteInPlayer(){
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
    public void workspaceAddInvertBlockAndExecuteInPlayer(){
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
    public void workspaceAddCustomBlockAndExecuteInPlayer(){
        Game game = new Game();
        EffectBlock custom = new CustomBlock();
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
}