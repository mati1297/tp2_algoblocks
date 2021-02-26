package algoblocks.gui.buttons;


import javafx.scene.control.Button;
import algoblocks.engine.*;
import algoblocks.engine.block.*;
import algoblocks.gui.GameController;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class DeleteAllButton extends Button{
    public static final String TEXT = "Delete All";
    ListView<String> targetList;

    public DeleteAllButton(GameController game, ListView<String> targetList){
        super();
        this.setText(TEXT);
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                game.clearWorkspace();
                targetList.getItems().clear();
            }
        });
    }
}