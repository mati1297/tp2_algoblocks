package algoblocks.gui.buttons;

import javafx.scene.control.Button;

import algoblocks.engine.block.*;
import algoblocks.gui.GameController;
import algoblocks.gui.ListViewInterface;

import java.util.ArrayList;

public class ActionBlockButton extends BlockButton {
    public ActionBlockButton(GameController game, ListViewInterface targetList, Block block) {
        super(game, targetList, block);
    }

    @Override
    public void action() {
        targetList.addActionBlock(block);
        game.addActionBlockToWorkspace(block);
    }

    public static ArrayList<Button> createButtonArray(GameController game, ListViewInterface targetList, ArrayList<Block> blocks) {
        ArrayList<Button> buttons = new ArrayList<Button>();
        blocks.forEach((Block block) -> {
            buttons.add(new ActionBlockButton(game, targetList, block));
        });
        return buttons;
    }
}