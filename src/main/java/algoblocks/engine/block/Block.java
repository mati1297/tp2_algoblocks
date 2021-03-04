package algoblocks.engine.block;

import algoblocks.engine.action.Sequence;

public abstract class Block {
    protected String name;

    public Block(String name){
        this.name = name;
    }

    public Block(Block original){
        this.name = original.name;
    }

    public Block(){
        name = "";
    }

    @Override
    public boolean equals(Object object){
        return !(object == null || getClass() != object.getClass());
    }

    public String getName(){
        return name;
    }

    public abstract Sequence getSequence();
    public abstract Sequence getInvertedSequence();
}