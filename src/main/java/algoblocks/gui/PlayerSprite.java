 package algoblocks.gui;

 import javafx.scene.image.Image;

public class PlayerSprite{
    public PlayerSprite(){
        
    }

    public Image get(boolean canDraw, boolean isMoving){
        if (isMoving) {
            if (canDraw) return new Image(SpritesPath.RUN_PENCIL_DOWN);
            return new Image(SpritesPath.RUN_PENCIL_UP);
        } else {
            if (canDraw) return new Image(SpritesPath.IDLE_PENCIL_DOWN);
            return new Image(SpritesPath.IDEL_PENCIL_UP);
        }
    }
}