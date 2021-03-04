package algoblocks.gui.buttons;

import algoblocks.gui.*;
import algoblocks.gui.GameController;

import javafx.scene.control.ListView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class CloseBlockButton extends Button {
    public static final String TEXT = "Close Block";
    ListView<String> targetList;

    public CloseBlockButton(GameController game, ListViewInterface targetList) {
        super();
        this.setText(TEXT);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.closeEffectBlock();
                targetList.closeEffectBlock();
            }
        });
    }
}