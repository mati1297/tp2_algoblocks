package algoblocks.view.whiteboard;

import algoblocks.controller.GameController;
import algoblocks.view.whiteboard.player.PlayerPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class WhiteboardCanvas {
    private WhiteboardGrid grid;
    private WhiteboardDrawing drawing;
    private PlayerPane playerPane;

    public WhiteboardCanvas(GameController gameController, double width, double height) {
        grid = new WhiteboardGrid(gameController, width, height);
        drawing = new WhiteboardDrawing(gameController, width, height);
        playerPane = new PlayerPane(gameController, width, height);
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