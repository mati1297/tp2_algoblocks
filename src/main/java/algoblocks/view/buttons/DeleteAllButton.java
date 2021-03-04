package algoblocks.view.buttons;

import algoblocks.view.workspace.WorkspaceView;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import algoblocks.controller.GameController;

public class DeleteAllButton extends Button {
    ListView<String> targetList;

    public DeleteAllButton(GameController gameController, WorkspaceView targetList) {
        super();
        this.setText(AlgorithmButtonNames.DELETE_ALL_BUTTON);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameController.clearWorkspace();
                targetList.clear();
            }
        });
    }
}