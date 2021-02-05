package algoblocks.engine;

public class MoveRightAction extends Action {
    public void execute(Player player) {
        player.move(new RightDirection());
    }
}