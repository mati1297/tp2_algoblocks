package algoblocks.engine;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.Block;
import algoblocks.engine.grid.Grid;
import algoblocks.engine.player.Player;

public class Game{
    private Workspace workspace;
    private Player player;
    private Whiteboard whiteboard;

    public Game(){
        player = new Player(new Grid(10, 10));
        workspace = new Workspace();
        whiteboard = new Whiteboard(new Grid(10, 10));
    }

    public void run() {
        Sequence sequence = workspace.compile();
        whiteboard.draw(player.run(sequence));
    }

    public void addBlockToWorkspace(Block newBlock){
        workspace.addBlock(newBlock);
    }

    public Player getPlayer(){
        return player;
    }
}