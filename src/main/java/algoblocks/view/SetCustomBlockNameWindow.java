package algoblocks.view;

import algoblocks.controller.SaveCustomBlockController;
import algoblocks.controller.handlers.CancelButtonHandler;
import algoblocks.controller.handlers.OkButtonHandler;
import algoblocks.view.buttons.*;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

public class SetCustomBlockNameWindow extends Window {
    private static final String title = "Set custom block name";
    private static final String labelText = "New custom block text";
    private static final String errorText = "No name inserted!";
    private static final String okText = "Ok";
    private static final String cancelText = "Cancel";

    private TextField textField;

    private static final int WIDTH = 200;
    private static final int HEIGHT = 140;

    public SetCustomBlockNameWindow(SaveCustomBlockController saveController) {
        super(title, WIDTH, HEIGHT);

        Label titleLabel = new Label(labelText);

        Label errorLabel = new Label(errorText);
        errorLabel.setTextFill(Color.web("#ff0000", 1));
        errorLabel.setVisible(false);

        Button okButton = new Button(okText);
        okButton.setDefaultButton(true);

        textField = new TextField();

        okButton.setOnAction(new OkButtonHandler(stage, saveController, errorLabel, textField));

        Button cancelButton = new Button(cancelText);
        cancelButton.setCancelButton(false);

        cancelButton.setOnAction(new CancelButtonHandler(stage));

        

        HBox buttonLayout = new HBox(cancelButton, okButton);
        buttonLayout.setAlignment(Pos.CENTER_RIGHT);

        VBox mainLayout = new VBox(titleLabel, errorLabel, textField, buttonLayout);
        mainLayout.setAlignment(Pos.CENTER_LEFT);
        mainLayout.setPadding(new Insets(5, 5, 5, 5));
        
        Scene scene = new Scene(mainLayout);

        stage.setScene(scene);    
    }
}