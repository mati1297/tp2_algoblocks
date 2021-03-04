package algoblocks.gui;

import algoblocks.engine.grid.*;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;

public class PlayerPane {
  private Pane pane;
  private PlayerSprite sprite;
  private GameController game;
  private int spriteSize;

  private double width;
  private double height;

  public PlayerPane(GameController game, double width, double height) {
    spriteSize = 90;
    this.game = game;
    pane = new Pane();
    sprite = new PlayerSprite();
    Rectangle clip = new Rectangle(width, height);
    pane.setClip(clip);
    this.width = width;
    this.height = height;
    pane.setMaxWidth(width);
    pane.setMaxHeight(height);
    this.updatePlayerSprite();
  }

  public Pane getPane() {
    return pane;
  }

  public void setSpriteSize(int size) {
    spriteSize = size;
  }

  public void clear() {
    pane.getChildren().clear();
  }

  public void updatePlayerSprite() {
    updatePlayerSprite(new Coordinates(), false, false);
  }

  public void updatePlayerSprite(Coordinates position, boolean canDraw, boolean isMoving) {
    this.clear();
    pane.getChildren().add(createPlayerSprite(position, canDraw, isMoving));
  }

  private ImageView createPlayerSprite(Coordinates playerPosition, boolean canDraw, boolean isMoving) {
    ImageView playerSprite = new ImageView(sprite.get(canDraw, isMoving));

    Size gridSize = game.getGridSize();
    int gridWidth = gridSize.width();
    int gridHeight = gridSize.height(); 

    Double centerX = (playerPosition.getX() + gridWidth / 2) * width / gridWidth;
    Double centerY = (-1 * playerPosition.getY() + gridHeight / 2) * height / gridHeight;

    playerSprite.setX(centerX - spriteSize / 2);
    playerSprite.setY(centerY - spriteSize);

    playerSprite.setFitWidth(spriteSize);
    playerSprite.setFitHeight(spriteSize);

    return playerSprite;
  }
}
