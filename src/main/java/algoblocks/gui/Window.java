package algoblocks.gui;

import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;

public class Window {
  protected int height;
  protected int width;
  protected Stage stage;

  public Window(String title, int width, int height) {
    this.width = width;
    this.height = height;

    stage = new Stage();
    stage.setTitle(title);
    stage.setHeight(height);
    stage.setWidth(width);
  }

  public Window(String title, int width, int height, Stage stage) {
    this.height = height;
    this.width = width;
    
    this.stage = new Stage();
    this.stage.setTitle(title);
    this.stage.setHeight(height);
    this.stage.setWidth(width);

    //max
  }

}
