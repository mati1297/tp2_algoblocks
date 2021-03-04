package algoblocks.engine.action;

import algoblocks.engine.player.Player;

public class RaisePencilAction extends Action {
    public void execute(Player player) {
        player.raisePencil();
    }
}