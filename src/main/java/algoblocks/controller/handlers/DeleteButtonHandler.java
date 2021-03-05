package algoblocks.controller.handlers;

import algoblocks.controller.GameController;
import algoblocks.view.workspace.WorkspaceView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class DeleteButtonHandler implements EventHandler<ActionEvent> {
    private GameController gameController;
    private WorkspaceView targetList;

    public DeleteButtonHandler(GameController gameController, WorkspaceView targetList){
        this.gameController = gameController;
        this.targetList = targetList;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        int index = targetList.getSelectedIndex();
        if(index >= 0) 
            gameController.deleteBlockFromWorkspace(index, targetList.remove(index));
    }
}
