package PiCar;

import javafx.application.Application;

import PiCar.Controllers.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    private Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scenes/HomeMenu.fxml"));
        AnchorPane pane = loader.load();

        Scene scene = new Scene(pane);

        primaryStage.setTitle("Display");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
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
