package algoblocks.controller.handlers;

import algoblocks.controller.GameController;
import algoblocks.controller.SaveCustomBlockController;
import javafx.scene.control.Label;
import algoblocks.view.workspace.WorkspaceView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class OkButtonHandler implements EventHandler<ActionEvent> {
    Stage stage;
    Label errorLabel;
    SaveCustomBlockController saveController;
    TextField textField;

    public OkButtonHandler(Stage stage, SaveCustomBlockController saveController, Label errorLabel, TextField textField){
        this.stage = stage;
        this.errorLabel = errorLabel;
        this.saveController = saveController;
        this.textField = textField;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        String blockName = textField.getText();
        if(blockName == "")
            errorLabel.setVisible(true);
        else {
            saveController.continueAction(blockName);
            stage.close();
        }
    }
}
