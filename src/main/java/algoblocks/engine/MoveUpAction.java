package algoblocks.engine;

public class MoveUpAction extends Action {
    public void execute(Player player) {
        player.move(new UpDirection());
    }
}