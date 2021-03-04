package algoblocks.view.buttons;

import algoblocks.view.workspace.WorkspaceView;
import javafx.scene.control.Button;

import algoblocks.engine.block.*;
import algoblocks.controller.GameController;

import java.util.ArrayList;

public class EffectBlockButton extends BlockButton {
    public EffectBlockButton(GameController gameController, WorkspaceView targetList, EffectBlock block) {
        super(gameController, targetList, block);
    }

    @Override
    public void action() {
        targetList.addEffectBlock(block);
        game.addEffectBlockToWorkspace((EffectBlock) block);
    }
    
    public static ArrayList<Button> createButtonArray(GameController game, WorkspaceView targetList, ArrayList<EffectBlock> blocks) {
        ArrayList<Button> buttons = new ArrayList<Button>();
        blocks.forEach((EffectBlock block) -> {
            buttons.add(new EffectBlockButton(game, targetList, block));
        });
        return buttons;
    }
}