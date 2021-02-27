package algoblocks.gui.buttons;


import javafx.scene.control.Button;
import algoblocks.gui.*;
import algoblocks.engine.*;
import algoblocks.engine.block.*;
import javafx.scene.control.ListView;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class RunButton extends Button{
    private static final String NAME = "Run";
    ArrayList<Button> buttonsToDisable;

    public RunButton(GameController game, WhiteboardCanvas whiteboardCanvas, ArrayList<Button> buttonsToDisable){
        super();
        RunDraw run = new RunDraw(game, whiteboardCanvas, buttonsToDisable);
        this.buttonsToDisable = buttonsToDisable;
        this.buttonsToDisable.add(this);
        this.setText(NAME);
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                run.execute();
            }
        });
    }

}