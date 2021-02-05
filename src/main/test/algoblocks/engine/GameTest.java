package algoblocks.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void workspaceAddBlockAndExecuteInPlayer(){
        Game game = new Game();
        Block moveDown = new MoveDownBlock();

        game.addBlockToWorkspace(moveDown);
        
        Coordinates expectedCoordinates = new Coordinates(0, -1);

        game.run();

        Player playerInGame = game.getPlayer();
        
        assertEquals(expectedCoordinates, playerInGame.getPosition());
    }
}