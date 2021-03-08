package algoblocks.view.buttons;

import algoblocks.controller.*;
import algoblocks.controller.handlers.SaveButtonHandler;
import algoblocks.view.*;
import algoblocks.engine.block.*;

import algoblocks.view.workspace.WorkspaceView;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class SaveButton extends Button {
    private WorkspaceView targetList;
    private BlockButton button;
    private GameController game;

    public SaveButton(SaveCustomBlockController saveController) {
        super();
        this.setText(AlgorithmButtonNames.SAVE_BUTTON);
        this.setOnAction(new SaveButtonHandler(saveController));
    }

}