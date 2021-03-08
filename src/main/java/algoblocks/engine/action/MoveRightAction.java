package algoblocks.engine.action;

import algoblocks.engine.player.Player;
import algoblocks.engine.player.RightDirection;

public class MoveRightAction extends Action {
    public void execute(Player player) {
        player.move(new RightDirection());
    }
}