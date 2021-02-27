package algoblocks.engine;


import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.*;

public class Workspace{
    private Algorithm algorithm;

    public Workspace(){
        algorithm = new Algorithm();
    }
    
    public void addBlock(Block newBlock){
        algorithm.addBlock(newBlock);
    }

    public void deleteBlock(int index){
        algorithm.deleteBlock(index);
    }

    public void clear(){
        algorithm.clear();
    }

    public Sequence compile(){
        return algorithm.compile();
    }

    public CustomBlock createCustomBlock(){
        return algorithm.createCustomBlock();
    }

}