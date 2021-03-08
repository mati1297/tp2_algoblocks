package algoblocks.controller.handlers;

import algoblocks.controller.GameController;
import algoblocks.controller.RunAlgorithm;
import algoblocks.controller.SaveCustomBlockController;
import algoblocks.view.workspace.WorkspaceView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class SaveButtonHandler implements EventHandler<ActionEvent> {
    private SaveCustomBlockController saveController;

    public SaveButtonHandler(SaveCustomBlockController saveController){
        this.saveController = saveController;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        saveController.showWindow();
    }
}
