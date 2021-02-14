package algoblocks.engine.drawing;

import java.util.ArrayList;

public class Drawing {
  private ArrayList<Shape> shapes;

  public Drawing(){
    shapes = new ArrayList<Shape>();
  }

  public Drawing(Drawing drawing){
    this.shapes = new ArrayList<Shape>();
    for (Shape shape: drawing.shapes){
        this.shapes.add(shape.makeCopy());
    }
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || getClass() != object.getClass())
        return false;

    if (this == object)
        return true;

    Drawing someDrawing = (Drawing)object;

    boolean isEqual = true;
    int index = 0;

    for(Shape shape : shapes)
      if(!shape.equals(someDrawing.get(index++))) {
        isEqual = false;
        break;
      }

    return isEqual;
  }

  public boolean isBlank() {
    for(Shape shape : shapes){
      if(!(shape instanceof Blank))
        return false;
    }

    return true;
  }

  public void addShape(Shape newShape){
    shapes.add(newShape);
  }

  public Shape get(int position) {
    return shapes.get(position);
  }

  public boolean isEmpty() {
    return shapes.isEmpty();
  }
}
