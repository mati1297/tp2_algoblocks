package algoblocks.view.buttons;

import algoblocks.engine.block.*;
import algoblocks.controller.handlers.*;

import javafx.scene.control.Button;

public abstract class BlockButton extends Button {
    protected Block block;

    public BlockButton(BlockButtonHandler handler, Block block) {
        super();
        this.block = block;
        this.setText(block.getName());
        this.setOnAction(handler);
    }

}