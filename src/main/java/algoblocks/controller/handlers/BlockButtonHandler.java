package algoblocks.controller.handlers;

import javafx.event.EventHandler;
import algoblocks.controller.GameController;
import algoblocks.view.workspace.WorkspaceView;
import javafx.event.ActionEvent;

public abstract class BlockButtonHandler implements EventHandler<ActionEvent> {
  protected GameController gameController;
  protected WorkspaceView workspaceView;

  public BlockButtonHandler(GameController gameController, WorkspaceView workspaceView) {
    this.gameController = gameController;
    this.workspaceView = workspaceView;
  }

  @Override
  public abstract void handle(ActionEvent event);
}