package algoblocks.engine;

public class MoveDownAction extends Action {
    public void execute(Player player){
        player.move(new DownDirection());
    }
}