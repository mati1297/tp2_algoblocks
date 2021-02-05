package algoblocks.engine;

public class MoveLeftAction extends Action {
    public void execute(Player player){
        player.move(new LeftDirection());
    }
}