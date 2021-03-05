package algoblocks.controller.handlers;

import algoblocks.controller.GameController;
import algoblocks.view.workspace.WorkspaceView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class DeleteAllButtonHandler implements EventHandler<ActionEvent> {
    private GameController gameController;
    private WorkspaceView targetList;

    public DeleteAllButtonHandler(GameController gameController, WorkspaceView targetList){
        this.gameController = gameController;
        this.targetList = targetList;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        gameController.clearWorkspace();
        targetList.clear();
    }
}
