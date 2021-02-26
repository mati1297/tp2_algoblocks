package algoblocks.gui;

import algoblocks.engine.*;
import algoblocks.engine.drawing.*;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

public class WhiteboardCanvas{
    private WhiteboardGrid grid;
    private WhiteboardDrawing drawing;

    WhiteboardCanvas(GameController game, double width, double height){
        grid = new WhiteboardGrid(game, width, height);
        drawing = new WhiteboardDrawing(game, width, height);
    }

    public StackPane getStackPane(){
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(grid.getPane(), drawing.getPane());
        return stackPane;
    }

    public ArrayList<Runnable> draw(){
        return drawing.draw();
    }

    public void clear(){
        drawing.clear();
    }


    //Draw
}
