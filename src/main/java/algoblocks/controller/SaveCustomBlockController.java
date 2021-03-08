package algoblocks.controller;

import algoblocks.view.workspace.WorkspaceView;
import algoblocks.view.buttons.CustomBlockButton;
import algoblocks.engine.block.*;
import algoblocks.view.SetCustomBlockNameWindow;


public class SaveCustomBlockController {
    private GameController gameController;
    private CustomBlockButton button;
    private WorkspaceView targetList;

    public SaveCustomBlockController(GameController gameController, WorkspaceView targetList, CustomBlockButton button){
        this.gameController = gameController;
        this.button = button;
        this.targetList = targetList;
    }

    public void showWindow() {
        SetCustomBlockNameWindow window = new SetCustomBlockNameWindow(this);
        window.show();
    }

    public void continueAction(String name) {
        CustomBlock block = gameController.createCustomBlock();
        gameController.clearWorkspace();
        block.setName(name);
        button.setText(name);
        targetList.clear();
        button.setBlock(block);
    }
}