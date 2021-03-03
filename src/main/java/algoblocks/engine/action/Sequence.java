package algoblocks.engine.action;

import algoblocks.engine.player.Player;

import java.util.ArrayList;

public class Sequence{
    private ArrayList<Action> actions;

    public Sequence(){
        actions = new ArrayList<Action>();
    }

    public Sequence(Action firstAction) {
        actions = new ArrayList<Action>();
        actions.add(firstAction);
    }

    public void run(Player player) {
        for(Action action : actions)
            action.execute(player);
    }

    public void addAction(Action newAction){
        actions.add(newAction);
    }

    public void concatenate(Sequence otherSecuence){
        actions.addAll(otherSecuence.actions);
    }

    public Action get(int pos){
        try{
            return actions.get(pos);
        } catch(IndexOutOfBoundsException e) {
            throw e;
        }
    }

    public boolean isEmpty(){
        return actions.isEmpty();
    }

    @Override
    public boolean equals(Object object){
        if (object == null || getClass() != object.getClass())
            return false;

        Sequence otherSequence = (Sequence) object;

        if(this == otherSequence)
            return true;

        if(actions.size() != otherSequence.actions.size())
            return false;
        int i = 0;
        
        for(Action action: actions){
            if(!action.equals(otherSequence.actions.get(i)))
                return false;
            i++;
        }
        return true;
    }
}