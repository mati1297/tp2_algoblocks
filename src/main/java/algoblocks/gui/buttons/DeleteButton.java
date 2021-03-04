package algoblocks.gui.buttons;

import algoblocks.gui.*;
import algoblocks.gui.GameController;

import javafx.scene.control.ListView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class DeleteButton extends Button {
    ListView<String> targetList;

    public DeleteButton(GameController game, ListViewInterface targetList) {
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