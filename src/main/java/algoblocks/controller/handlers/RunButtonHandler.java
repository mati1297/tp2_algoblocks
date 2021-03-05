package algoblocks.controller.handlers;

import algoblocks.controller.GameController;
import algoblocks.controller.RunAlgorithm;
import algoblocks.view.workspace.WorkspaceView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class RunButtonHandler implements EventHandler<ActionEvent> {
    private RunAlgorithm runAlgorithm;

    public RunButtonHandler(RunAlgorithm runAlgorithm){
        this.runAlgorithm = runAlgorithm;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        runAlgorithm.execute();
    }
}
