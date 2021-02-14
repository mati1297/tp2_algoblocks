package algoblocks.engine;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Algorithm{
    private List<Block> blocks;

    public Algorithm(){
        blocks = new ArrayList<Block>();
    }

    public void addBlock(Block newBlock){
        blocks.add(newBlock);
    }

    public void deleteBlock(int index){
        //validar
        blocks.remove(index);
    }

    public void clear(){
        blocks.clear();
    }

    public Sequence compile(){
        Sequence output = new Sequence();

        blocks.stream().forEach((block)->{
            output.concatenate(block.getSequence());
        });

        return output;
    }
    
}