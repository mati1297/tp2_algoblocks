package algoblocks.gui;

import algoblocks.engine.*;
import algoblocks.engine.block.*;
import algoblocks.engine.drawing.*;
import algoblocks.engine.grid.*;
import algoblocks.gui.buttons.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.geometry.Pos;
// import javafx.scene.Cursor;
// import javafx.geometry.Rectangle2D;
// import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
// import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
// import javafx.stage.Screen;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
// import javafx.geometry.Insets;
// import javafx.application.Application;
// import javafx.scene.Group;
// import javafx.scene.Scene;
import javafx.scene.control.Button;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
// import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
// import javafx.stage.Stage;
import javafx.event.EventHandler;
// import javafx.event.ActionEvent;

// import java.beans.EventHandler;
// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application {
    private static final Window window = new Window(800, 600); // BUSCAR COMO BLOQUEAR TAMAÑO
    private static final double GRID_WIDTH = window.getWidth() * 0.6;
    private static final double GRID_HEIGHT = GRID_WIDTH;
    private static final ArrayList<Block> BASE_BLOCKS = new ArrayList<Block>(Arrays.asList(new Block[]{
        new MoveUpBlock(),
        new MoveDownBlock(),
        new MoveLeftBlock(),
        new MoveRightBlock(),
        new RaisePencilBlock(),
        new LowerPencilBlock(),
    }));

    private static Game game;

    public static void main(String[] args) {
        game = new Game();
        launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("AlgoBlocks");
        stage.setHeight(window.getHeight());
        stage.setWidth(window.getWidth());

//      String s = "File:resources/ok.png";
//      Image okImage = new Image(s);
//      Button okBtn = new Button();
//      okBtn.setGraphic(new ImageView(okImage));
//      okBtn.setPrefSize(520, 520);
//      moveLeft.setPadding(Insets.EMPTY);

        ListView<String> algorithmContainer = new ListView<String>();
        algorithmContainer.setPrefHeight(window.getHeight() * 0.8);
        algorithmContainer.setId("algorithmContainer");

        HBox blockContainer = new HBox();
        blockContainer.setPrefHeight(window.getHeight() / 10);
        blockContainer.setSpacing(10);
        blockContainer.setAlignment(Pos.TOP_CENTER);
        blockContainer.getChildren().addAll(BlockButton.createButtonArray(game, algorithmContainer, BASE_BLOCKS));

        

//      Label gridLabel = new Label("grid");
//      Pane gridContainer = new Pane(gridLabel);

        Pane whiteboardCanvas = new Pane(); 
        whiteboardCanvas.setPrefHeight(GRID_HEIGHT);
        whiteboardCanvas.setPrefWidth(GRID_WIDTH);

        Pane whiteboardGrid = new Pane();
        whiteboardGrid.setId("whiteboard");
        whiteboardGrid.setPrefHeight(GRID_HEIGHT);
        whiteboardGrid.setPrefWidth(GRID_WIDTH);
        whiteboardGrid.getChildren().addAll(createGrid());
        // whiteboardCanvas.setAlignment(Pos.CENTER_LEFT);

        StackPane whiteboardStack = new StackPane();
        whiteboardStack.getChildren().addAll(whiteboardGrid, whiteboardCanvas);
        // whiteboardStack.setAlignment(Pos.CENTER);

        Button deleteButton = new DeleteButton(game, algorithmContainer);

        Button deleteAllButton = new DeleteAllButton(game, algorithmContainer);

        //crear clase.
        Button runButton = buttonConstructor("Run", actionConstructor(() -> {
            game.run();
            Platform.runLater(() -> whiteboardCanvas.getChildren().clear());
            Drawing drawing = game.getDrawing();
            drawWhiteboard(drawing, whiteboardCanvas);
        }));

        HBox deleteButtonsContainer = new HBox(deleteButton, deleteAllButton, runButton);
        deleteButtonsContainer.setSpacing(10);
        deleteButtonsContainer.setAlignment(Pos.BOTTOM_CENTER);
    
        VBox algorithmAndDeleteButtons = new VBox(algorithmContainer, deleteButtonsContainer);


        HBox secondaryContainer = new HBox();
        secondaryContainer.getChildren().addAll(algorithmAndDeleteButtons, whiteboardStack);

        VBox mainContainer = new VBox(blockContainer, secondaryContainer);
        mainContainer.setVgrow(secondaryContainer, Priority.ALWAYS);
        mainContainer.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainContainer);
        //scene.getStylesheets().add("File:src/resources/styles.css");

//      scene.setCursor(Cursor.MOVE);
        stage.setScene(scene);

        stage.show();
    }

    public Button buttonConstructor(String buttonName, EventHandler<ActionEvent> onAction) {
        Button button = new Button();
        button.setText(buttonName);
        button.setOnAction(onAction);
        return button;
    }

    public Button buttonConstructor(String buttonName, EventHandler<ActionEvent> onAction, String id) {
        Button button = buttonConstructor(buttonName, onAction);
        button.setId(id);
        return button;
    }

    public EventHandler<ActionEvent> actionConstructor(Runnable action) {
        return new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                action.run();
            }
        };
    }

    public void drawWhiteboard(Drawing drawing, Pane whiteboard){
        ArrayList<Runnable> tasks = new ArrayList<Runnable>();        

        drawing.forEach((Shape shape) -> {
            Runnable task = () -> Platform.runLater(() -> whiteboard.getChildren().add(createLine(shape)));
            tasks.add(task);
        });

        executeChainOfEvents(tasks, 500, TimeUnit.MILLISECONDS);
    }

    public void executeChainOfEvents(ArrayList<Runnable> tasks, int duration, TimeUnit timeUnit) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        for (int i = 0; i < tasks.size(); i++)
            executor.schedule(tasks.get(i), (i + 1) * duration, timeUnit);

        executor.shutdown();
    }

    public ArrayList<Line> createGrid() {
        ArrayList<Line> lines = new ArrayList<Line>();

        Size gridSize = game.getGridSize();
        int gridWidth = gridSize.width();
        int gridHeight = gridSize.height();

        for(int i = 1; i < gridWidth; i++) {
            Line line = new Line();

            line.setStroke(Color.GRAY);
            line.setStrokeWidth(1);

            line.setStartX(i *  GRID_WIDTH / gridWidth);
            line.setEndX(i *  GRID_WIDTH / gridWidth);
            line.setStartY(0);
            line.setEndY(gridHeight * GRID_HEIGHT / gridHeight);

            lines.add(line);
        }

        for(int i = 1; i < gridHeight; i++) {
            Line line = new Line();

            line.setStroke(Color.GRAY);
            line.setStrokeWidth(1);

            line.setStartX(0);
            line.setEndX(gridWidth * GRID_WIDTH / gridWidth);
            line.setStartY(i * GRID_HEIGHT / gridHeight);
            line.setEndY(i * GRID_HEIGHT / gridHeight);

            lines.add(line);
        }

        return lines;
    }

    public Line createLine(Shape shape){
        Line line = new Line();

        Size gridSize = game.getGridSize();
        int gridWidth = gridSize.width();
        int gridHeight = gridSize.height();

        line.setStroke(new Color(0, 0, 0, shape.getAlpha()));
        line.setStrokeWidth(3);

        Coordinates start = shape.getStart();
        Coordinates end = shape.getFinish();

        line.setStartX((start.getX() + gridWidth / 2) *  GRID_WIDTH / gridWidth);
        line.setEndX((end.getX() + gridWidth / 2) * GRID_WIDTH / gridWidth);
        line.setStartY((-1 * start.getY() + gridHeight / 2) * GRID_HEIGHT / gridHeight);
        line.setEndY((-1 * end.getY() + gridHeight / 2) * GRID_HEIGHT / gridHeight);

        return line;
    }
}