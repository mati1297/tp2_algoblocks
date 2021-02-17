package algoblocks.gui;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Window {
  private double height;
  private double width;

  public Window() {
    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    width = screenBounds.getWidth();
    height = screenBounds.getHeight();
  }

  public Window(double width, double height) {
    this.width = width;
    this.height = height;
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
