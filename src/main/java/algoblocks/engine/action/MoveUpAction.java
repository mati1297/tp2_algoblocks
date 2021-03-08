package algoblocks.engine.action;

import algoblocks.engine.player.Player;
import algoblocks.engine.player.UpDirection;

public class MoveUpAction extends Action {
    public void execute(Player player) {
        player.move(new UpDirection());
    }
}