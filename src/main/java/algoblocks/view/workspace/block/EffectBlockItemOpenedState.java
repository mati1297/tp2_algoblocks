package algoblocks.view.workspace.block;

public class EffectBlockItemOpenedState extends EffectBlockItemState {
    @Override
    public String toString() {
        return "Opened";
    }

    @Override
    public boolean isOpened() {
        return true;
    }
}