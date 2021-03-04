package algoblocks.view.workspace.block;

import algoblocks.engine.block.*;

public abstract class BlockItem {
    protected Block block;

    public BlockItem(Block block) {
        this.block = block;
    }

    @Override
    public abstract String toString();
}