package algoblocks.gui.buttons;

import javafx.scene.control.Button;

import algoblocks.engine.block.*;
import algoblocks.gui.GameController;
import algoblocks.gui.ListViewInterface;

import java.util.ArrayList;

public class EffectBlockButton extends BlockButton {
    public EffectBlockButton(GameController game, ListViewInterface targetList, EffectBlock block) {
        super(game, targetList, block);
    }

    @Override
    public void action() {
        targetList.addEffectBlock(block);
        game.addEffectBlockToWorkspace((EffectBlock) block);
    }
    
    public static ArrayList<Button> createButtonArray(GameController game, ListViewInterface targetList, ArrayList<EffectBlock> blocks) {
        ArrayList<Button> buttons = new ArrayList<Button>();
        blocks.forEach((EffectBlock block) -> {
            buttons.add(new EffectBlockButton(game, targetList, block));
        });
        return buttons;
    }
}