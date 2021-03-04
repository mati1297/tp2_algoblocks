package algoblocks.gui;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class WhiteboardCanvas {
    private WhiteboardGrid grid;
    private WhiteboardDrawing drawing;
    private PlayerPane playerPane;

    WhiteboardCanvas(GameController game, double width, double height) {
        grid = new WhiteboardGrid(game, width, height);
        drawing = new WhiteboardDrawing(game, width, height);
        playerPane = new PlayerPane(game, width, height);
    }

    public StackPane getStackPane() {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(grid.getPane(), drawing.getPane(), playerPane.getPane());
        return stackPane;
    }

    public ArrayList<Runnable> draw() {
        return drawing.draw(playerPane);
    }

    public void clear() {
        drawing.clear();
    }
}