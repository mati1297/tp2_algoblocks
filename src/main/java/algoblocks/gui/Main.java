package algoblocks.gui;


import algoblocks.engine.*;
import algoblocks.engine.block.*;
import algoblocks.engine.grid.*;
import algoblocks.engine.drawing.*;
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
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Main extends Application{

    private static final int WINDOW_HEIGHT=600;//900;
    private static final int WINDOW_WIDTH=800;//1600;

    private static Game game;

    public static void main(String[] args) {
        game = new Game();
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

        ListView algorithmContainer = new ListView();
        
        //El string deberia salir del nombre del bloque.
        Button moveUpButton = new Button();
        setButton(moveUpButton, new MoveUpBlock(), "Move Up", algorithmContainer);
        Button moveDownButton = new Button();
        setButton(moveDownButton, new MoveDownBlock(), "Move Down", algorithmContainer);
        Button moveLeftButton = new Button();
        setButton(moveLeftButton, new MoveLeftBlock(), "Move Left", algorithmContainer);
        Button moveRightButton = new Button();
        setButton(moveRightButton, new MoveRightBlock(), "Move Right", algorithmContainer);
        Button raisePencilButton = new Button();
        setButton(raisePencilButton, new RaisePencilBlock(), "Raise Pencil", algorithmContainer);
        Button lowerPencilButton = new Button();
        setButton(lowerPencilButton, new LowerPencilBlock(), "Lower Pencil", algorithmContainer);


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
        Pane gridContainer = new Pane(gridLabel);

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                int index = algorithmContainer.getSelectionModel().getSelectedIndex();
                if(index >= 0){
                    game.deleteBlockFromWorkspace(index);
                    algorithmContainer.getItems().remove(index);
                }
            }
        });

        Button deleteAllButton = new Button("Delete All");
        deleteAllButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                algorithmContainer.getItems().clear();
                game.clearWorkspace();
            }
        });
        

        Button runButton = new Button("Run");
        runButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                game.run();
                Drawing drawing = game.getDrawing();
            }
        });

        HBox deleteButtonsContainer = new HBox(deleteButton, deleteAllButton, runButton);
        deleteButtonsContainer.setSpacing(10);
        deleteButtonsContainer.setAlignment(Pos.BOTTOM_CENTER);
    
        VBox algorithmAndDeleteButtons = new VBox(algorithmContainer, deleteButtonsContainer);


        HBox secondaryContainer = new HBox();
//        secondaryContainer.set
        secondaryContainer.getChildren().addAll(algorithmAndDeleteButtons, gridContainer);

        VBox mainContainer = new VBox(blockContainer, secondaryContainer);
        mainContainer.setVgrow(secondaryContainer, Priority.ALWAYS);
        mainContainer.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainContainer, WINDOW_WIDTH, WINDOW_HEIGHT, Color.WHITE);
//        scene.setCursor(Cursor.MOVE);
        stage.setScene(scene);

        stage.show();
    }

    public void setButton(Button button, Block block, String string, ListView listView){
        button.setText(string);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                listView.getItems().add(string);
                game.addBlockToWorkspace(block);
            }
        });
        
    }
}