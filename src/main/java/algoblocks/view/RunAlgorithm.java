package algoblocks.view;

import algoblocks.controller.GameController;
import algoblocks.view.whiteboard.WhiteboardCanvas;
import javafx.application.Platform;
import javafx.scene.control.Button;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class RunAlgorithm {
    private static final int DELAY = 500;

    private WhiteboardCanvas whiteboardCanvas;
    private GameController game;
    private ArrayList<Button> buttonsToDisable;

    public RunAlgorithm(GameController game, WhiteboardCanvas whiteboardCanvas) {
        this.whiteboardCanvas = whiteboardCanvas;
        this.game = game;
        this.buttonsToDisable = new ArrayList<Button>();
    }

    public void execute() {
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

    private void disableButtons() {
        buttonsToDisable.forEach((Button button) -> {
            Platform.runLater(() -> button.setDisable(true));
        });
    }

    private void enableButtons() {
        buttonsToDisable.forEach((Button button) -> {
            Platform.runLater(() -> button.setDisable(false));
        });
    }

    public void setButtonsToDisable(ArrayList<Button> buttonsToDisable) {
        this.buttonsToDisable = buttonsToDisable;
    }
}