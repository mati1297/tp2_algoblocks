package algoblocks.gui.buttons;


import javafx.scene.control.Button;
import algoblocks.engine.*;
import algoblocks.engine.block.*;
import algoblocks.gui.GameController;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class CloseBlockButton extends Button{
    public static final String TEXT = "Close Block";
    ListView<String> targetList;

    public CloseBlockButton(GameController game, ListView<String> targetList){
        super();
        this.setText(TEXT);
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                game.closeEffectBlock();
            }
        });
    }
}