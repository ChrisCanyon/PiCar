package PiCar.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GasInput {

    @FXML
    private TextField actiontarget;


    public void loadHandler(Stage stage, GridPane pane) {
        actiontarget.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)) {
                System.out.println("doing stuff\n");
                pushed(stage, actiontarget, pane);
            }
        });
    }


    private void pushed(Stage stage, TextField userTextField, GridPane pane){
        final Text text = new Text();
        pane.add(text,2,1);
        try {
            Double x = Double.parseDouble(userTextField.getText());
        } catch (NumberFormatException e) {
            text.setFill(Color.RED);
            text.setText("Error: Please enter a number");
            userTextField.clear();
            userTextField.requestFocus();
            return;
        }
        text.setFill(Color.GREEN);
        text.setText("Doing stuff!");
    }

}
