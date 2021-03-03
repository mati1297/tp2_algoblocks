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


public class SetCustomBlockNameWindow extends Window{
    private static final String title = "Set custom block name";
    private static final String labelText = "New custom block text";
    private static final String okText = "Ok";
    private static final String cancelText = "Cancel";

    private static final int WIDTH = 200;
    private static final int HEIGHT = 100;



    public SetCustomBlockNameWindow(SaveButton button){
        super(title, WIDTH, HEIGHT);

        Label titleLabel = new Label(labelText);
        

        
        Button okButton = new Button(okText);
        Button cancelButton = new Button(cancelText);

        
        
        TextField textField = new TextField();

        HBox buttonLayout = new HBox(okButton, cancelButton);
        VBox mainLayout = new VBox(titleLabel, textField, buttonLayout);
        
        
        Scene scene = new Scene(mainLayout); //set 


        okButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                button.continueAction(textField.getText());
                stage.close();
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                stage.close();
            }
        });

        stage.setScene(scene);
        stage.show();
        
    }
}