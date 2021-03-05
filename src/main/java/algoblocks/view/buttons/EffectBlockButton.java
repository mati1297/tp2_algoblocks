package algoblocks.view.buttons;

import algoblocks.view.workspace.WorkspaceView;
import javafx.scene.control.Button;

import algoblocks.engine.block.*;
import algoblocks.controller.*;
import algoblocks.controller.handlers.*;

import java.util.ArrayList;

public class EffectBlockButton extends BlockButton {
    public EffectBlockButton(GameController game, WorkspaceView targetList, EffectBlock block) {
        super(new EffectBlockButtonHandler(game, targetList, block), block);
    }
    
    public static ArrayList<Button> createButtonArray(GameController game, WorkspaceView targetList, ArrayList<EffectBlock> blocks) {
        ArrayList<Button> buttons = new ArrayList<Button>();
        blocks.forEach((EffectBlock block) -> {
            buttons.add(new EffectBlockButton(game, targetList, block));
        });
        return buttons;
    }
}