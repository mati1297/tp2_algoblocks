package algoblocks.engine.action;

import algoblocks.engine.player.LeftDirection;
import algoblocks.engine.player.Player;

public class MoveLeftAction extends Action {
    public void execute(Player player) {
        player.move(new LeftDirection());
    }
}