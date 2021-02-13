package algoblocks.engine.action;

import algoblocks.engine.player.Player;

public class LowerPencilAction extends Action {
    public void execute(Player player) {
        player.lowerPencil();
    }
}