package algoblocks.engine.grid;

public class Size {
  private int width;
  private int height;

  public Size(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public boolean equals(Object object) {
      if (object == null || getClass() != object.getClass())
          return false;

      Size someSize = (Size) object;

      return width == someSize.width && height == someSize.height;
  }

  public int width() {
    return width;
  }

  public int height() {
    return height;
  }

}
