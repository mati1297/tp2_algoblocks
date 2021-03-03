package algoblocks.engine.action;

import algoblocks.engine.player.DownDirection;
import algoblocks.engine.player.Player;

public class MoveDownAction extends Action {
    public void execute(Player player) {
        player.move(new DownDirection());
    }
}