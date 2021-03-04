package algoblocks.view.buttons;

import algoblocks.view.workspace.WorkspaceView;
import javafx.scene.control.Button;

import algoblocks.engine.block.*;
import algoblocks.controller.GameController;

import java.util.ArrayList;

public class CustomBlockButton extends BlockButton {
    public CustomBlockButton(GameController game, WorkspaceView targetList, Block block) {
        super(game, targetList, block);
    }

    @Override
    public void action() {
        targetList.addActionBlock(block);
        game.addActionBlockToWorkspace(block);
    }

    public static ArrayList<Button> createButtonArray(GameController game, WorkspaceView targetList, ArrayList<Block> blocks) {
        ArrayList<Button> buttons = new ArrayList<Button>();
        blocks.forEach((Block block) -> {
            buttons.add(new ActionBlockButton(game, targetList, block));
        });
        return buttons;
    }
}