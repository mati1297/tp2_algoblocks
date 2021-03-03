package algoblocks.gui.buttons;


import javafx.scene.control.Button;
import algoblocks.gui.*;
import algoblocks.engine.block.*;
import algoblocks.engine.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;




public class SaveButton extends Button{
    private ListViewInterface targetList;
    private static final String NAME = "Save";
    private BlockButton button;
    private GameController game;

    public SaveButton(GameController game, ListViewInterface targetList, BlockButton button){
        super();
        this.setText(NAME);
        this.button = button;
        this.button.setDisable(true);
        this.targetList = targetList;
        this.game = game;
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                //bloquear todo
                showWindow();
            }
        });
    }

    public void showWindow(){
        SetCustomBlockNameWindow window = new SetCustomBlockNameWindow(this);
        window.show();
    }

    public void continueAction(String name){
        CustomBlock block = game.createCustomBlock();
        game.clearWorkspace();
        block.setName(name);
        button.setText(name);
        targetList.clear();
        button.setBlock(block);
        button.setDisable(false);  
    }

}