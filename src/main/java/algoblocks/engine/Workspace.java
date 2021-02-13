package algoblocks.engine;


import algoblocks.engine.action.Sequence;
import algoblocks.engine.block.Block;

public class Workspace{
    private Algorithm algorithm;

    public Workspace(){
        algorithm = new Algorithm();
    }
    
    public void addBlock(Block newBlock){
        algorithm.addBlock(newBlock);
    }

    public Sequence compile(){
        return algorithm.compile();
    }

}