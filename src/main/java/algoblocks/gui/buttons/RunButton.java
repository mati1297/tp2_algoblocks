package algoblocks.gui.buttons;

import algoblocks.gui.*;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class RunButton extends Button {
    private static final String NAME = "Run";
    ArrayList<Button> buttonsToDisable;

    public RunButton(RunAlgorithm run) {
        super();
        this.setText(NAME);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                run.execute();
            }
        });
    }
}