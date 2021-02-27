package algoblocks.gui.buttons;


import javafx.scene.control.Button;
import algoblocks.engine.*;
import algoblocks.engine.block.*;
import algoblocks.gui.GameController;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import algoblocks.gui.*;


public class DeleteButton extends Button{
    public static final String TEXT = "Delete";
    ListView<String> targetList;

    public DeleteButton(GameController game, ListViewInterface targetList){
        super();
        this.setText(TEXT);
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                int index = targetList.getSelectedIndex();
                if(index >= 0){
                    game.deleteBlockFromWorkspace(index, targetList.remove(index));
                    
                }
            }
        });
    }
}