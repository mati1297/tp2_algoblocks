package algoblocks.view.workspace.block;

public class EffectBlockItemClosedState extends EffectBlockItemState {
    @Override
    public String toString() {
        return "Closed";
    }
    
    @Override
    public boolean isOpened() {
        return false;
    }
}