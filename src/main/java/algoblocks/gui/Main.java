package algoblocks.gui;

// import algoblocks.engine.*;
import algoblocks.engine.block.*;
// import algoblocks.engine.drawing.*;
// import algoblocks.engine.grid.*;
import algoblocks.gui.buttons.*;
import javafx.application.Application;
// import javafx.application.Platform;
// import javafx.event.ActionEvent;
import javafx.geometry.Insets;

// import java.util.concurrent.Executors;
// import java.util.concurrent.ScheduledExecutorService;
// import java.util.concurrent.TimeUnit;

import javafx.geometry.Pos;
// import javafx.scene.Cursor;
// import javafx.geometry.Rectangle2D;
// import javafx.scene.chart.NumberAxis;
// import javafx.scene.control.*;
import javafx.scene.layout.*;
// import javafx.scene.paint.Color;
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
// import javafx.scene.shape.Line;
// import javafx.stage.Stage;
// import javafx.event.EventHandler;
// import javafx.event.ActionEvent;

// import java.beans.EventHandler;
// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application {
    private static final Window window = new Window(800, 600);
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

    private static final ArrayList<Block> EFFECT_BLOCKS = new ArrayList<Block>(Arrays.asList(new Block[]{
        new RepeatBlock(2),
        new RepeatBlock(3),
        new InvertBlock(),
    }));

    private static GameController gameController;

    public static void main(String[] args) {
        gameController = new GameController();
        launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("AlgoBlocks");
        stage.setHeight(window.getHeight());
        stage.setWidth(window.getWidth());

        ListViewInterface algorithmListView = new ListViewInterface();
        algorithmListView.setPrefHeight(window.getHeight() * 0.8);
        algorithmListView.setId("algorithmContainer");

        FlowPane blockContainer = new FlowPane();
        // blockContainer.setPrefHeight(window.getHeight() / 10);
        blockContainer.setPadding(new Insets(5, 5, 5, 5));
        blockContainer.setVgap(5);
        blockContainer.setHgap(5);
        blockContainer.setAlignment(Pos.TOP_CENTER);

        ArrayList<Button> blockButtons = ActionBlockButton.createButtonArray(gameController, algorithmListView, BASE_BLOCKS);
        blockButtons.addAll(EffectBlockButton.createButtonArray(gameController, algorithmListView, EFFECT_BLOCKS));

        ActionBlockButton customBlockButton = new ActionBlockButton(gameController, algorithmListView, new CustomBlock());
        blockContainer.getChildren().addAll(blockButtons);
        blockContainer.getChildren().add(customBlockButton);


        WhiteboardCanvas whiteboardCanvas = new WhiteboardCanvas(gameController, GRID_WIDTH, GRID_HEIGHT);

        // whiteboardStack.setAlignment(Pos.CENTER);

        Button deleteButton = new DeleteButton(gameController, algorithmListView);
        Button deleteAllButton = new DeleteAllButton(gameController, algorithmListView);
        Button closeBlockButton = new CloseBlockButton(gameController, algorithmListView);
        Button saveButton = new SaveButton(gameController, algorithmListView, customBlockButton);
        ArrayList<Button> buttonsToDisable = new ArrayList<Button>();
        buttonsToDisable.add(deleteButton);
        buttonsToDisable.add(deleteAllButton);
        buttonsToDisable.add(closeBlockButton);
        buttonsToDisable.add(saveButton);
        buttonsToDisable.addAll(blockButtons);
        Button runButton = new RunButton(gameController, whiteboardCanvas, buttonsToDisable);

        HBox deleteButtonsContainer = new HBox(deleteButton, deleteAllButton, closeBlockButton, saveButton, runButton);
        deleteButtonsContainer.setSpacing(10);
        deleteButtonsContainer.setAlignment(Pos.BOTTOM_CENTER);
    
        VBox algorithmAndDeleteButtons = new VBox(algorithmListView.getListView(), deleteButtonsContainer);


        HBox secondaryContainer = new HBox();
        secondaryContainer.getChildren().addAll(algorithmAndDeleteButtons, whiteboardCanvas.getStackPane());

        VBox mainContainer = new VBox(blockContainer, secondaryContainer);
        mainContainer.setVgrow(secondaryContainer, Priority.ALWAYS);
        mainContainer.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainContainer);
        //scene.getStylesheets().add("File:src/resources/styles.css");

//      scene.setCursor(Cursor.MOVE);
        stage.setScene(scene);

        stage.show();
    }


}