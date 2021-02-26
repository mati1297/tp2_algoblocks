package algoblocks.gui;

import algoblocks.engine.Game;
import algoblocks.gui.WhiteboardCanvas;
import javafx.application.Platform;
import java.util.ArrayList;

import javafx.scene.control.Button;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RunDraw{
    private static final int DELAY = 500;

    private WhiteboardCanvas whiteboardCanvas;
    private Game game;
    private ArrayList<Button> buttonsToBlock;

    public RunDraw(Game game, WhiteboardCanvas whiteboardCanvas, ArrayList<Button> buttonsToBlock){
        this.whiteboardCanvas = whiteboardCanvas;
        this.game = game;
        this.buttonsToBlock = buttonsToBlock;
    }

    public void execute(){
        disableButtons();
        game.run();
        Platform.runLater(() -> whiteboardCanvas.clear());
        ArrayList<Runnable> tasks = whiteboardCanvas.draw();
        Runnable enableButtons = () -> Platform.runLater(() -> enableButtons());
        tasks.add(enableButtons);
        executeChainOfEvents(tasks, DELAY, TimeUnit.MILLISECONDS);
    }

    private void executeChainOfEvents(ArrayList<Runnable> tasks, int duration, TimeUnit timeUnit) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        for (int i = 0; i < tasks.size(); i++)
            executor.schedule(tasks.get(i), (i + 1) * duration, timeUnit);

        executor.shutdown();
    }

    private void disableButtons(){
        buttonsToBlock.forEach((Button button) -> {
            Platform.runLater(() -> button.setDisable(true));
        });
    }

    private void enableButtons(){
        buttonsToBlock.forEach((Button button) -> {
            Platform.runLater(() -> button.setDisable(false));
        });
    }
}