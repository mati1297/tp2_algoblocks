package algoblocks.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static MainWindow mainWindow;
    private static GameController gameController;

    public static void main(String[] args) {
        gameController = new GameController();
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        mainWindow = new MainWindow(stage, gameController, 800, 600);
        mainWindow.show();
    }
}