package algoblocks.engine;

import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.Block;

import java.util.ArrayList;
import java.util.List;

public class Algorithm{
    private List<Block> blocks;

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

    public void print() {
        blocks.forEach((block) -> System.out.println(block));
    }

    public void addBlock(Block newBlock){
        blocks.add(newBlock);
    }

    public void deleteBlock(int index){
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
    
}