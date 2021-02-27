package algoblocks.gui;

import algoblocks.engine.*;
import algoblocks.engine.grid.*;
import algoblocks.engine.drawing.*;
import algoblocks.engine.block.*;
import java.util.ArrayList;

public class GameController{
    private Game game;
    private ArrayList<EffectBlock> openedBlocks;

    public GameController(){
        game = new Game();
        openedBlocks = new ArrayList<EffectBlock>();
    }


    public void addActionBlockToWorkspace(Block block){
        if(!openedBlocks.isEmpty())
            openedBlocks.get(openedBlocks.size() - 1).addBlock(block);
        else
            game.addBlockToWorkspace(block);
    }

    public void addEffectBlockToWorkspace(Block block){
        EffectBlock effectBlock;
        effectBlock = (EffectBlock) block;
        effectBlock = effectBlock.makeCopy();
        if(!openedBlocks.isEmpty())
            openedBlocks.get(openedBlocks.size() - 1).addBlock(effectBlock);
        else
            game.addBlockToWorkspace(effectBlock);
        openedBlocks.add(effectBlock);
    }

    public Drawing getDrawing(){
        return game.getDrawing();
    }

    public Size getGridSize(){
        return game.getGridSize();
    }

    public void deleteBlockFromWorkspace(int index, boolean opened){
        if(opened)
            openedBlocks.clear();
        game.deleteBlockFromWorkspace(index);
    }

    public void run(){
        game.run();
    }

    public void clearWorkspace(){
        game.clearWorkspace();
        openedBlocks.clear();
    }

    public void closeEffectBlock(){
        if(!openedBlocks.isEmpty())
            openedBlocks.remove(openedBlocks.size() - 1);
    }

    public CustomBlock createCustomBlock(){
        return game.createCustomBlock();
    }
}