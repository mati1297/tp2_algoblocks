package algoblocks.engine;


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