package algoblocks.gui.buttons;

import javafx.scene.control.Button;
import algoblocks.engine.*;
import algoblocks.engine.block.*;
import algoblocks.gui.GameController;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class ActionBlockButton extends BlockButton{
    public ActionBlockButton(GameController game, ListView<String> targetList, Block block){
        super(game, targetList, block);
    }

    @Override
    public void action(){
        targetList.getItems().add(block.getBlockName());
        game.addActionBlockToWorkspace(block);
    }

    
    public static ArrayList<Button> createButtonArray(GameController game, ListView<String> targetList, ArrayList<Block> blocks){
        ArrayList<Button> buttons = new ArrayList<Button>();
        //validate
        blocks.forEach((Block block) -> {
            buttons.add(new ActionBlockButton(game, targetList, block));
        });
        return buttons;
    }
}