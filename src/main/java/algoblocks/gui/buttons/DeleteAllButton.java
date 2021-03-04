package algoblocks.gui.buttons;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import algoblocks.gui.GameController;
import algoblocks.gui.*;

public class DeleteAllButton extends Button {
    ListView<String> targetList;

    public DeleteAllButton(GameController game, ListViewInterface targetList) {
        super();
        this.setText(AlgorithmButtonNames.DELETE_ALL_BUTTON);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.clearWorkspace();
                targetList.clear();
            }
        });
    }
}