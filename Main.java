package PiCar;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Main extends Application {

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

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/GasMenu.fxml"));

        Scene scene = new Scene(root, 300, 275);

        primaryStage.setTitle("FXML Gas input");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }




/*
  primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Do something");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label userName = new Label("Gas");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(grid, 300, 250));
        primaryStage.show();

        grid.add(btn, 10, 10, 2, 1);

        primaryStage.setFullScreen(true);

        final Text actionTarget = new Text();
        grid.add(actionTarget, 1, 6);

        userTextField.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER))
                pushed(actionTarget, userTextField);
        });

        btn.setOnAction(event -> pushed(actionTarget, userTextField));
 */
















}
