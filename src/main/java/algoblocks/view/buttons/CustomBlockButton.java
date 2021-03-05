package algoblocks.view.buttons;

import javafx.scene.control.Button;

import algoblocks.engine.block.*;
import algoblocks.controller.GameController;
import algoblocks.controller.handlers.*;
import algoblocks.view.workspace.WorkspaceView;

import java.util.ArrayList;

public class CustomBlockButton extends BlockButton {
    ActionBlockButtonHandler handler;

    public CustomBlockButton(GameController gameController, WorkspaceView targetList, Block block) {
        super(null, block);
        handler = new ActionBlockButtonHandler(gameController, targetList, block);
        this.setOnAction(handler);
    }

    public static ArrayList<Button> createButtonArray(GameController game, WorkspaceView targetList, ArrayList<Block> blocks) {
        ArrayList<Button> buttons = new ArrayList<Button>();
        blocks.forEach((Block block) -> {
            buttons.add(new CustomBlockButton(game, targetList, block));
        });
        return buttons;
    }


    public void setBlock(Block block){
        this.block = block;
        this.setText(block.getName());
        handler.updateBlock(block);
    }
}