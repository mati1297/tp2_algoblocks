package algoblocks.gui;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Window {
  private double height;
  private double width;

  public Window() {
    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    height = screenBounds.getWidth();
    width = screenBounds.getHeight();
  }

  public Window(double width, double height) {
    this.height = width;
    this.width = height;
  }

  public double getRatio() {
    return width / height;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }
}
