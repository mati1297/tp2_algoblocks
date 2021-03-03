package algoblocks.gui;

import algoblocks.engine.block.*;
import algoblocks.gui.buttons.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application {
    
    private static MainWindow mainWindow;
    private static GameController gameController;

    public static void main(String[] args) {
        gameController = new GameController();
        launch(args);
    }

    @Override
    public void start(Stage stage){
        mainWindow = new MainWindow(stage, gameController, 800, 600);
    }


}