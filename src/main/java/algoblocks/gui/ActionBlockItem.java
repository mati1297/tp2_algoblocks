package algoblocks.gui;

import algoblocks.engine.block.*;

public class ActionBlockItem extends BlockItem {
    public ActionBlockItem(Block block) {
        super(block);
    }

    public String toString() {
        return block.getBlockName();
    }
}