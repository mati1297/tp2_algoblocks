package algoblocks.controller.handlers;

import algoblocks.controller.GameController;
import algoblocks.view.workspace.WorkspaceView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class CancelButtonHandler implements EventHandler<ActionEvent> {
    Stage stage;

    public CancelButtonHandler(Stage stage){
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        stage.close();
    }
}
