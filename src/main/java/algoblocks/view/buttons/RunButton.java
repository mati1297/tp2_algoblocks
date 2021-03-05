package algoblocks.view.buttons;

import algoblocks.view.*;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import algoblocks.controller.handlers.RunButtonHandler;
import algoblocks.controller.RunAlgorithm;


public class RunButton extends Button {
    public RunButton(RunAlgorithm run) {
        super();
        this.setText(AlgorithmButtonNames.RUN_BUTTON);
        this.setOnAction(new RunButtonHandler(run));
    }
}