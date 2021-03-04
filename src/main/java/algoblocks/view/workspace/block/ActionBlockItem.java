package algoblocks.view.workspace.block;

import algoblocks.engine.block.*;

public class ActionBlockItem extends BlockItem {
    public ActionBlockItem(Block block) {
        super(block);
    }

    public String toString() {
        return block.getName();
    }
}