package algoblocks.gui;


import algoblocks.gui.buttons.*;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;


public class SetCustomBlockNameWindow{
    private static final String title = "Set custom block name";
    private static final String labelText = "New custom block text";
    private static final String okText = "Ok";
    private static final String cancelText = "Cancel";

    private Stage window;

    public SetCustomBlockNameWindow(SaveButton button){
        Stage window = new Stage();

        Label titleLabel = new Label(title);
        

        
        Button okButton = new Button(okText);
        Button cancelButton = new Button(cancelText);

        
        
        TextField textField = new TextField();

        HBox buttonLayout = new HBox(okButton, cancelButton);
        VBox mainLayout = new VBox(titleLabel, textField, buttonLayout);
        
        
        Scene scene = new Scene(mainLayout, 230, 100); //set 


        okButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                button.continueAction(textField.getText());
                window.close();
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                window.close();
            }
        });

        window.setTitle(title);
        window.setScene(scene);
        window.show();
        
    }
}