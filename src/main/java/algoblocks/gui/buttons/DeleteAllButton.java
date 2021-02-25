package algoblocks.gui.buttons;


import javafx.scene.control.Button;
import algoblocks.engine.*;
import algoblocks.engine.block.*;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class DeleteAllButton extends Button{
    public static final String TEXT = "Delete All";
    Game game;
    ListView<String> targetList;

    public DeleteAllButton(Game game, ListView<String> targetList){
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