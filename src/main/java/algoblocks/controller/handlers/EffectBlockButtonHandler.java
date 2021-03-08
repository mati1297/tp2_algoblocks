package algoblocks.controller.handlers;

import algoblocks.controller.GameController;
import algoblocks.view.workspace.WorkspaceView;
import algoblocks.engine.block.*;

import javafx.event.ActionEvent;

public class EffectBlockButtonHandler extends BlockButtonHandler {
  Block block;

  public EffectBlockButtonHandler(GameController gameController, WorkspaceView workspaceView, Block block) {
    super(gameController, workspaceView);
    this.block = block;
  }

  public void handle(ActionEvent event) {
    workspaceView.addEffectBlock(block);
    gameController.addEffectBlockToWorkspace((EffectBlock) block);
  }
}