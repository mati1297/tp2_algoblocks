package algoblocks.engine;

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

    public Sequence compile(){
        Sequence output = new Sequence();

        blocks.stream().forEach((block)->{
            output.concatenate(block.getSequence());
        });

        return output;
    }
    
}