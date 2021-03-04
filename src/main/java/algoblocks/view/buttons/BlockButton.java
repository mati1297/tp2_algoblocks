package algoblocks.view.buttons;

import algoblocks.engine.block.*;
import algoblocks.controller.GameController;

import algoblocks.view.workspace.WorkspaceView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public abstract class BlockButton extends Button {
    protected WorkspaceView targetList;
    protected Block block;
    protected GameController game;

    public BlockButton(GameController gameController, WorkspaceView targetList, Block block) {
        super();
        this.targetList = targetList;
        this.game = gameController;
        this.block = block;
        this.setText(block.getName());
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                action();
            }
        });
    }

    public void setBlock(Block block) {
        this.block = block;
        this.setText(block.getName());
    }

    public abstract void action();
}