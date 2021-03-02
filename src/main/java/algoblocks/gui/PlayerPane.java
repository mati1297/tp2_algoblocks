package algoblocks.gui;

import algoblocks.engine.*;
import algoblocks.engine.drawing.Drawing;
import algoblocks.engine.drawing.Shape;
import algoblocks.engine.grid.*;
import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerPane {
  private Pane pane;
  private GameController game;

  private double width;
  private double height;

  public PlayerPane(GameController game, double width, double height){
    this.game = game;
    pane = new Pane();
    this.width = width;
    this.height = height;
    pane.setPrefWidth(width);
    pane.setPrefHeight(height);
    this.updatePlayerSprite(game.getPlayerPosition());
  }

  public Pane getPane() {
    return pane;
  }

  public void clear() {
    pane.getChildren().clear();
  }

  public void updatePlayerSprite(Coordinates position) {
    this.clear();
    pane.getChildren().add(createPlayerSprite(position));
  }

  private ImageView createPlayerSprite(Coordinates playerPosition) {
    ImageView playerSprite = new ImageView(game.getPlayerSprite());

    Size gridSize = game.getGridSize();
    int gridWidth = gridSize.width();
    int gridHeight = gridSize.height(); 

    Double centerX = (playerPosition.getX() + gridWidth / 2) * width / gridWidth;
    Double centerY = (-1 * playerPosition.getY() + gridHeight / 2) * height / gridHeight;

    playerSprite.setX(centerX - 32);
    playerSprite.setY(centerY - 64);

    playerSprite.setFitWidth(64);
    playerSprite.setFitHeight(64);

    return playerSprite;
  }
}
