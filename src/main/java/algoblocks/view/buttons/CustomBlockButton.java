package algoblocks.view.buttons;

import javafx.scene.control.Button;

import algoblocks.engine.block.*;
import algoblocks.controller.GameController;
import algoblocks.controller.handlers.*;
import algoblocks.view.workspace.WorkspaceView;

import java.util.ArrayList;

public class CustomBlockButton extends BlockButton {
    public CustomBlockButton(GameController game, WorkspaceView targetList, Block block) {
        super(new ActionBlockButtonHandler(game, targetList, block), block);
    }

    public static ArrayList<Button> createButtonArray(GameController game, WorkspaceView targetList, ArrayList<Block> blocks) {
        ArrayList<Button> buttons = new ArrayList<Button>();
        blocks.forEach((Block block) -> {
            buttons.add(new CustomBlockButton(game, targetList, block));
        });
        return buttons;
    }
}