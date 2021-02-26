package algoblocks.gui.buttons;


import javafx.scene.control.Button;
import algoblocks.engine.*;
import algoblocks.engine.block.*;
import algoblocks.gui.GameController;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public abstract class BlockButton extends Button{
    protected ListView<String> targetList;
    protected Block block;
    protected GameController game;

    public BlockButton(GameController game, ListView<String> targetList, Block block){
        super();
        this.targetList = targetList;
        this.game = game;
        this.block = block;
        this.setText(block.getBlockName());
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                action();
            }
        });
    }

    public abstract void action();
    
}