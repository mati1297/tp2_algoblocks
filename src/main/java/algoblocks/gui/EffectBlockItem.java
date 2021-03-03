package algoblocks.gui;

import algoblocks.engine.block.*;
import java.util.ArrayList;

public class EffectBlockItem extends BlockItem{
    private ArrayList<BlockItem> children;
    private EffectBlockItemState state;
    private int level;

    public EffectBlockItem(Block block, int level){
        super(block);
        this.level = level;
        children = new ArrayList<BlockItem>();
        state = new EffectBlockItemOpenedState();
    }

    public void addChild(BlockItem blockItem){
        children.add(blockItem);
    }

    public void close(){
        state = new EffectBlockItemClosedState();
    }

    @Override
    public String toString(){
        String output = block.getBlockName() + "(" + state.toString() + ")";
        String tabs = "";
        for (int i = 0; i <= level; i++){
            tabs += "\t";
        }
        for(BlockItem child: children){
            output += "\n" + tabs + child.toString();
        }
        return output;
    }

    public boolean isOpened(){
        return state.isOpened();
    }
}