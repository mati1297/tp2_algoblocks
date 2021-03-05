package algoblocks.view.buttons;

import algoblocks.view.workspace.WorkspaceView;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import algoblocks.controller.handlers.DeleteAllButtonHandler;

import algoblocks.controller.GameController;

public class DeleteAllButton extends Button {

    public DeleteAllButton(GameController gameController, WorkspaceView targetList) {
        super();
        this.setText(AlgorithmButtonNames.DELETE_ALL_BUTTON);
        this.setOnAction(new DeleteAllButtonHandler(gameController, targetList));
    }
}