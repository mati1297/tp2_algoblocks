package algoblocks.gui;

import algoblocks.engine.*;
import algoblocks.engine.grid.*;
import algoblocks.engine.drawing.*;
import algoblocks.engine.block.*;

import java.lang.reflect.Constructor;

import java.util.ArrayList;



public class GameController {
    private Game game;
    private ArrayList<EffectBlock> openedBlocks;

    public GameController() {
        game = new Game();
        openedBlocks = new ArrayList<EffectBlock>();
    }

    public Coordinates getPlayerPosition() {
        return game.getPlayer().getPosition();
    }

    public boolean canPlayerDraw() {
        return game.getPlayer().canDraw();
    }

    public void addActionBlockToWorkspace(Block block) {
        if(!openedBlocks.isEmpty())
            openedBlocks.get(openedBlocks.size() - 1).addBlock(block);
        else
            game.addBlockToWorkspace(block);
    }

    public void addEffectBlockToWorkspace(EffectBlock block) {
        EffectBlock effectBlock = new InvertBlock();
        Constructor<? extends EffectBlock> constructor = null;
        try{
            constructor = block.getClass().getDeclaredConstructor(block.getClass());
        }
        catch(Exception e) {
            System.out.println(e.toString());
         }
        try{
            effectBlock = constructor.newInstance(block);
        }
        catch(Exception e){System.out.println(e);}



        if(!openedBlocks.isEmpty())
            openedBlocks.get(openedBlocks.size() - 1).addBlock(effectBlock);
        else
            game.addBlockToWorkspace(effectBlock);

        openedBlocks.add(effectBlock);
    }

    public Drawing getDrawing() {
        return game.getDrawing();
    }

    public Size getGridSize() {
        return game.getGridSize();
    }

    public void deleteBlockFromWorkspace(int index, boolean opened) {
        if(opened)
            openedBlocks.clear();
        game.deleteBlockFromWorkspace(index);
    }

    public void run() {
        game.run();
    }

    public void clearWorkspace() {
        game.clearWorkspace();
        openedBlocks.clear();
    }

    public void closeEffectBlock() {
        if(!openedBlocks.isEmpty())
            openedBlocks.remove(openedBlocks.size() - 1);
    }

    public CustomBlock createCustomBlock() {
        return game.createCustomBlock();
    }
}