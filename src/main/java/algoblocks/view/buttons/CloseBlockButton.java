package algoblocks.view.buttons;

import algoblocks.controller.GameController;

import algoblocks.view.workspace.WorkspaceView;
import javafx.scene.control.ListView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import algoblocks.controller.handlers.CloseBlockButtonHandler;

public class CloseBlockButton extends Button {
    public CloseBlockButton(GameController gameController, WorkspaceView targetList) {
        super();
        this.setText(AlgorithmButtonNames.CLOSE_BLOCK_BUTTON);
        this.setOnAction(new CloseBlockButtonHandler(gameController, targetList));
    }
}