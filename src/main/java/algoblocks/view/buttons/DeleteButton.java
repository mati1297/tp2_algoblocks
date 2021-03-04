package algoblocks.view.buttons;

import algoblocks.controller.GameController;

import algoblocks.view.workspace.WorkspaceView;
import javafx.scene.control.ListView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class DeleteButton extends Button {
    ListView<String> targetList;

    public DeleteButton(GameController game, WorkspaceView targetList) {
        super();
        this.setText(AlgorithmButtonNames.DELETE_BUTTON);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int index = targetList.getSelectedIndex();
                if(index >= 0) {
                    game.deleteBlockFromWorkspace(index, targetList.remove(index));
                    
                }
            }
        });
    }
}