package algoblocks.view.buttons;

import algoblocks.controller.GameController;

import algoblocks.view.workspace.WorkspaceView;
import javafx.scene.control.ListView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class CloseBlockButton extends Button {
    ListView<String> targetList;

    public CloseBlockButton(GameController game, WorkspaceView targetList) {
        super();
        this.setText(AlgorithmButtonNames.CLOSE_BLOCK_BUTTON);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.closeEffectBlock();
                targetList.closeEffectBlock();
            }
        });
    }
}