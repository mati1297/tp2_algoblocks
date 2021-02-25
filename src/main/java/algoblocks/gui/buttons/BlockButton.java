package algoblocks.gui.buttons;


import javafx.scene.control.Button;
import algoblocks.engine.*;
import algoblocks.engine.block.*;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class BlockButton extends Button{
    Game game;
    ListView<String> targetList;
    Block block;

    public BlockButton(Game game, ListView<String> targetList, Block block){
        super();
        this.targetList = targetList;
        this.game = game;
        this.block = block;
        this.setText(block.getBlockName());
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                targetList.getItems().add(block.getBlockName());
                game.addBlockToWorkspace(block);
            }
        });
    }

    public static ArrayList<Button> createButtonArray(Game game, ListView<String> targetList, ArrayList<Block> blocks){
        ArrayList<Button> buttons = new ArrayList<Button>();

        blocks.forEach((Block block) -> {
            buttons.add(new BlockButton(game, targetList, block));
        });
        return buttons;
    }
}