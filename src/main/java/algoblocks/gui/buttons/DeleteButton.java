package algoblocks.gui.buttons;


import javafx.scene.control.Button;
import algoblocks.engine.*;
import algoblocks.engine.block.*;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class DeleteButton extends Button{
    public static final String TEXT = "Delete";
    Game game;
    ListView<String> targetList;

    public DeleteButton(Game game, ListView<String> targetList){
        super();
        this.setText(TEXT);
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                int index = targetList.getSelectionModel().getSelectedIndex();
                if(index >= 0){
                    game.deleteBlockFromWorkspace(index);
                    targetList.getItems().remove(index);
                }
            }
        });
    }
}