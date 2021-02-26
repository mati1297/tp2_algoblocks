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
    RunDraw run;
    ArrayList<Button> buttonsToBlock;

    public RunButton(Game game, WhiteboardCanvas whiteboardCanvas, ArrayList<Button> buttonsToBlock){
        super();
        run = new RunDraw(game, whiteboardCanvas, buttonsToBlock);
        this.buttonsToBlock = buttonsToBlock;
        this.buttonsToBlock.add(this);
        this.setText(NAME);
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                run.execute();
            }
        });
    }

}