package algoblocks.gui;

import algoblocks.engine.*;
import algoblocks.engine.drawing.Drawing;
import algoblocks.engine.drawing.Shape;
import algoblocks.engine.grid.*;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

public class WhiteboardDrawing{
    private Pane pane;
    private GameController game;

    private double width;
    private double height;

    public WhiteboardDrawing(GameController game, double width, double height){
        this.game = game;
        pane = new Pane();
        this.width = width;
        this.height = height;
        pane.setMaxWidth(width);
        pane.setMaxHeight(height);
    }

    public Pane getPane(){
        return pane;
    }

    public void clear(){
        pane.getChildren().clear();
    }

    public ArrayList<Runnable> draw(PlayerPane playerPane){
        ArrayList<Runnable> tasks = new ArrayList<Runnable>();

        Platform.runLater(() -> playerPane.updatePlayerSprite());

        Drawing drawing = game.getDrawing();

        drawing.forEach((Shape shape) -> {
            Runnable task = () -> {
                Platform.runLater(() -> {
                    playerPane.updatePlayerSprite(shape.getFinish(), !shape.isBlank(), true);
                    pane.getChildren().add(createLine(shape));
                });
            };
            tasks.add(task);
        });

        tasks.add(() -> {
            Platform.runLater(() -> {
                playerPane.updatePlayerSprite(game.getPlayerPosition(), game.canPlayerDraw(), false);
            });
        });

        return tasks;

        

        //aca deberia ir la parte de activar los botones de nuevo.
    }

    private Line createLine(Shape shape){
        Line line = new Line();

        Size gridSize = game.getGridSize();
        int gridWidth = gridSize.width();
        int gridHeight = gridSize.height();

        line.setStroke(new Color(0, 0, 0, shape.getAlpha()));
        line.setStrokeWidth(3);

        Coordinates start = shape.getStart();
        Coordinates end = shape.getFinish();

        line.setStartX((start.getX() + gridWidth / 2) *  width / gridWidth);
        line.setEndX((end.getX() + gridWidth / 2) * width / gridWidth);
        line.setStartY((-1 * start.getY() + gridHeight / 2) * height / gridHeight);
        line.setEndY((-1 * end.getY() + gridHeight / 2) * height / gridHeight);

        return line;
    }


}
