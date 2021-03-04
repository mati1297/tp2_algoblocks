package algoblocks.gui.buttons;

import algoblocks.gui.*;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class RunButton extends Button {
    ArrayList<Button> buttonsToDisable;

    public RunButton(RunAlgorithm run) {
        super();
        this.setText(AlgorithmButtonNames.RUN_BUTTON);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                run.execute();
            }
        });
    }
}