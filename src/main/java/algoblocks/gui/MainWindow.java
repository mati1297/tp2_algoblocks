package algoblocks.gui;


import javax.swing.text.html.ListView;
import algoblocks.engine.block.*;
import algoblocks.gui.buttons.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Arrays;


public class MainWindow extends Window{
    private static final String title = "AlgoBlocks";
    private ListViewInterface algorithmListView;
    private ArrayList<Button> blockButtons;
    private CustomBlockButton customBlockButton;
    private RunAlgorithm runAlgorithm;

    private FlowPane blockContainer;
    private FlowPane actionButtonsContainer;
    private GameController gameController;
    private WhiteboardCanvas whiteboardCanvas;
    private double grid_width;
    private double grid_height;

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

    public MainWindow(Stage stage, GameController gameController, int width, int height){
        super(title, width, height, stage);

        this.gameController = gameController;

        grid_width = width * 0.6;
        grid_height = grid_width;
        
        whiteboardCanvas = new WhiteboardCanvas(gameController, grid_width, grid_height);

        runAlgorithm = new RunAlgorithm(gameController, whiteboardCanvas);

        createAndSetBlockListView();
        createAndSetBlockButtons();
        createAndSetAlgorithmButtons();


        

        VBox algorithmAndDeleteButtons = new VBox(algorithmListView.getListView(), actionButtonsContainer);
        algorithmAndDeleteButtons.setMaxWidth(width - grid_width);

        HBox secondaryContainer = new HBox();
        secondaryContainer.getChildren().addAll(algorithmAndDeleteButtons, whiteboardCanvas.getStackPane());

        VBox mainContainer = new VBox(blockContainer, secondaryContainer);
        mainContainer.setVgrow(secondaryContainer, Priority.ALWAYS);
        mainContainer.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainContainer);
        this.stage.setScene(scene);
        this.stage.show();
        
    }


    private void createAndSetBlockListView(){
        algorithmListView = new ListViewInterface();
        algorithmListView.setPrefHeight(height * 0.8);
        algorithmListView.setId("algorithmContainer");
    }


    private void createAndSetBlockButtons(){
        blockContainer = new FlowPane();
        blockContainer.setPadding(new Insets(5, 5, 5, 5));
        blockContainer.setVgap(5);
        blockContainer.setHgap(5);
        blockContainer.setAlignment(Pos.TOP_CENTER);

        blockButtons = ActionBlockButton.createButtonArray(gameController, algorithmListView, BASE_BLOCKS);
        blockButtons.addAll(EffectBlockButton.createButtonArray(gameController, algorithmListView, EFFECT_BLOCKS));
        customBlockButton = new CustomBlockButton(gameController, algorithmListView, new CustomBlock());
        blockButtons.add(customBlockButton);

        blockContainer.getChildren().addAll(blockButtons);
    }


    private void createAndSetAlgorithmButtons(){
        Button deleteButton = new DeleteButton(gameController, algorithmListView);
        Button deleteAllButton = new DeleteAllButton(gameController, algorithmListView);
        Button closeBlockButton = new CloseBlockButton(gameController, algorithmListView);
        Button saveButton = new SaveButton(gameController, algorithmListView, customBlockButton);
        Button runButton = new RunButton(runAlgorithm);
        ArrayList<Button> buttonsToDisable = new ArrayList<Button>();
        buttonsToDisable.add(deleteButton);
        buttonsToDisable.add(deleteAllButton);
        buttonsToDisable.add(closeBlockButton);
        buttonsToDisable.add(saveButton);
        buttonsToDisable.add(runButton);
        buttonsToDisable.addAll(blockButtons);
        runAlgorithm.setButtonsToDisable(buttonsToDisable);
        

        actionButtonsContainer = new FlowPane(deleteButton, deleteAllButton, closeBlockButton, saveButton, runButton);
        actionButtonsContainer.setPadding(new Insets(5, 5, 5, 5));
        actionButtonsContainer.setVgap(5);
        actionButtonsContainer.setHgap(5);
        actionButtonsContainer.setAlignment(Pos.BOTTOM_CENTER);
    }

}