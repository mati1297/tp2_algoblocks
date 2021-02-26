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
        ArrayList<Button> blockButtons = BlockButton.createButtonArray(game, algorithmContainer, BASE_BLOCKS);
        blockContainer.getChildren().addAll(blockButtons);


        WhiteboardCanvas whiteboardCanvas = new WhiteboardCanvas(game, GRID_WIDTH, GRID_HEIGHT);
        StackPane whiteboardStack = whiteboardCanvas.getStackPane();

        // whiteboardStack.setAlignment(Pos.CENTER);

        Button deleteButton = new DeleteButton(game, algorithmContainer);

        Button deleteAllButton = new DeleteAllButton(game, algorithmContainer);

        ArrayList<Button> buttonsToBlock = new ArrayList<Button>();
        buttonsToBlock.add(deleteButton);
        buttonsToBlock.add(deleteAllButton);
        buttonsToBlock.addAll(blockButtons);
        Button runButton = new RunButton(game, whiteboardCanvas, buttonsToBlock);

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


}