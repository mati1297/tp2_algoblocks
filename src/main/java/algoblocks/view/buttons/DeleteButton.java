package algoblocks.view.buttons;

import algoblocks.controller.GameController;

import algoblocks.view.workspace.WorkspaceView;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import algoblocks.controller.handlers.DeleteButtonHandler;

public class DeleteButton extends Button {

    public DeleteButton(GameController gameController, WorkspaceView targetList) {
        super();
        this.setText(AlgorithmButtonNames.DELETE_BUTTON);
        this.setOnAction(new DeleteButtonHandler(gameController, targetList));
    }
}