package PiCar.Controllers;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GasInputController {


    private void pushed(Text actionTarget, TextField userTextField){
        try {
            Double x = Double.parseDouble(userTextField.getText());
        } catch (NumberFormatException e) {
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText("Error: Please enter a number");
            userTextField.clear();
            userTextField.requestFocus();
            return;
        }
        actionTarget.setFill(Color.GREEN);
        actionTarget.setText("Doing stuff!");
    }
}
