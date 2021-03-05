package algoblocks.controller.handlers;

import algoblocks.controller.GameController;
import algoblocks.view.workspace.WorkspaceView;
import algoblocks.engine.block.*;

import javafx.event.ActionEvent;

public class ActionBlockButtonHandler extends BlockButtonHandler {
  Block block;

  public ActionBlockButtonHandler(GameController gameController, WorkspaceView workspaceView, Block block) {
    super(gameController, workspaceView);
    this.block = block;
  }

  public void updateBlock(Block block){
    this.block = block;
  }

  public void handle(ActionEvent event) {
    workspaceView.addActionBlock(block);
    gameController.addActionBlockToWorkspace(block);
  }
}