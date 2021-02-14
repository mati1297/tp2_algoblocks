package algoblocks.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{

    private static final int WINDOW_HEIGHT=600;//900;
    private static final int WINDOW_WIDTH=800;//1600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("AlgoBlocks");

//        String s = "File:resources/ok.png";
//        Image okImage = new Image(s);
//        Button okBtn = new Button();
//        okBtn.setGraphic(new ImageView(okImage));
//        okBtn.setPrefSize(520, 520);
//        moveLeft.setPadding(Insets.EMPTY);

        Button moveUpButton = new Button();
        moveUpButton.setText("Move up");
        Button moveDownButton = new Button();
        moveDownButton.setText("Move down");
        Button moveLeftButton = new Button();
        moveLeftButton.setText("Move left");
        Button moveRightButton = new Button();
        moveRightButton.setText("Move right");
        Button raisePencilButton = new Button();
        raisePencilButton.setText("Raise pencil");
        Button lowerPencilButton = new Button();
        lowerPencilButton.setText("Lower pencil");

        HBox blockContainer = new HBox();
        blockContainer.setSpacing(10);
        blockContainer.setAlignment(Pos.TOP_CENTER);
        blockContainer.getChildren().addAll(moveUpButton,
                                            moveDownButton,
                                            moveLeftButton,
                                            moveRightButton,
                                            raisePencilButton,
                                            lowerPencilButton);

        Label gridLabel = new Label("grid");
        Label moveUpLabel = new Label("Move Up");
        Label moveDownLabel = new Label("Move Down");
        Pane gridContainer = new Pane(gridLabel);

        ListView algorithmContainer = new ListView();
        algorithmContainer.getItems().add(moveUpLabel);
        algorithmContainer.getItems().add(moveUpLabel);
        algorithmContainer.getItems().add(moveDownLabel);

        HBox secondaryContainer = new HBox();
//        secondaryContainer.set
        secondaryContainer.getChildren().addAll(algorithmContainer, gridContainer);

        VBox mainContainer = new VBox(blockContainer, secondaryContainer);
        mainContainer.setVgrow(secondaryContainer, Priority.ALWAYS);
        mainContainer.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainContainer, WINDOW_WIDTH, WINDOW_HEIGHT, Color.WHITE);
//        scene.setCursor(Cursor.MOVE);
        stage.setScene(scene);

        stage.show();
    }
}