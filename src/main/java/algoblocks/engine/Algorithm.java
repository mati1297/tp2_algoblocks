package algoblocks.engine;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.*;
import java.util.ArrayList;

public class Algorithm{
    private ArrayList<Block> blocks;

    public Algorithm(){
        blocks = new ArrayList<Block>();
    }

    @Override
    public boolean equals(Object object){
        if (object == null || getClass() != object.getClass())
            return false;

        Algorithm otherAlgorithm = (Algorithm) object;

        if (otherAlgorithm.blocks.size() != blocks.size())
            return false;

        for (int i = 0; i < blocks.size(); i++)
            if (!blocks.get(i).equals(otherAlgorithm.blocks.get(i)))
                return false;

        return true;
    }


    public void addBlock(Block newBlock){
        blocks.add(newBlock);
    }

    public void deleteBlock(int index){
        //validate
        if(index < blocks.size())
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

    public CustomBlock createCustomBlock(){
        return new CustomBlock(blocks);
    }
    
}