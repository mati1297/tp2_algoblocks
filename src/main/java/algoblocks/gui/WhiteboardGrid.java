package algoblocks.gui;

import algoblocks.engine.*;
import algoblocks.engine.drawing.*;
import algoblocks.engine.grid.*;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import algoblocks.gui.*;

public class WhiteboardGrid{
    private Pane pane;
    private GameController game;

    private double width;
    private double height;

    public WhiteboardGrid(GameController game, double width, double height){
        this.game = game;
        pane = new Pane();
        this.width = width;
        this.height = height;
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
        pane.getChildren().addAll(createGrid());
    }

    public Pane getPane(){
        return pane;
    }


    private ArrayList<javafx.scene.shape.Line> createGrid() {
        ArrayList<javafx.scene.shape.Line> lines = new ArrayList<Line>();

        Size gridSize = game.getGridSize();
        int gridWidth = gridSize.width();
        int gridHeight = gridSize.height();

        for(int i = 1; i < gridWidth; i++) {
            javafx.scene.shape.Line line = new javafx.scene.shape.Line();

            line.setStroke(Color.GRAY);
            line.setStrokeWidth(1);

            line.setStartX(i *  width / gridWidth);
            line.setEndX(i *  width / gridWidth);
            line.setStartY(0);
            line.setEndY(gridHeight * height / gridHeight);

            lines.add(line);
        }

        for(int i = 1; i < gridHeight; i++) {
            javafx.scene.shape.Line line = new javafx.scene.shape.Line();

            line.setStroke(Color.GRAY);
            line.setStrokeWidth(1);

            line.setStartX(0);
            line.setEndX(gridWidth * width / gridWidth);
            line.setStartY(i * height / gridHeight);
            line.setEndY(i * height / gridHeight);

            lines.add(line);
        }

        return lines;
    }
}
