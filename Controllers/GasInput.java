package PiCar.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class GasInput {

    @FXML
    private TextField inputField;

    @FXML
    private GridPane root;

    @FXML
    private Button enter;

    @FXML
    private Label errorLabel;
    @FXML
    void submitData() {
        double value;
        try {
            value = Double.parseDouble(inputField.getText());
        } catch (Throwable e){
            errorLabel.setText("Please enter a number");
            inputField.setText("");
            inputField.requestFocus();
            return;
        }
        //todo save data and reset distance travelled to 0;
        errorLabel.setTextFill(Color.GREEN);
        errorLabel.setText("Processing");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/HomeMenu.fxml"));
        AnchorPane pane;
        Stage stage = (Stage) root.getScene().getWindow();

        try {
            pane = loader.load();
        } catch (Throwable e) {
            e.printStackTrace();
            return;
        }

        stage.getScene().setRoot(pane);
        stage.setTitle("Display");

    }

    @FXML
    void keyHandler(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)){
            submitData();
        }
    }

}