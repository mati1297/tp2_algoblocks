package algoblocks.engine;

import algoblocks.engine.action.*;
import algoblocks.engine.block.*;
import algoblocks.engine.grid.*;
import algoblocks.engine.player.*;
import algoblocks.engine.drawing.*;

public class Game {
    private Workspace workspace;
    private Player player;
    private Whiteboard whiteboard;

    public Game() {
        player = new Player(new Grid(10, 10));
        workspace = new Workspace();
        whiteboard = new Whiteboard(new Grid(10, 10));
    }

    public void run() {
        player.resetPlayer();
        Sequence sequence = workspace.compile();
        whiteboard.draw(player.run(sequence));
    }

    public Size getGridSize() {
        return whiteboard.getSize();
    }

    public void addBlockToWorkspace(Block newBlock) {
        workspace.addBlock(newBlock);
    }

    public void deleteBlockFromWorkspace(int index) {
        workspace.deleteBlock(index);
    }

    public void clearWorkspace() {
        workspace.clear();
    }

    public Drawing getDrawing() {
        return whiteboard.getDrawing();
    }

    public Player getPlayer() {
        return player;
    }

    public CustomBlock createCustomBlock() {
        CustomBlock output = workspace.createCustomBlock();
        return output;
    }
}