package PiCar.Controllers;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HomeMenu {

    @FXML
    private Label mphDisplay;

    @FXML
    private MenuItem settings;

    @FXML
    private Label mpgDisplay;

    @FXML
    private Button tripReset;

    @FXML
    private Label tripDisplay;

    @FXML
    private ProgressBar fuelGuage;

    @FXML
    private LineChart<?, ?> mphChart;

    @FXML
    private MenuButton settingMenu;

    @FXML
    private MenuItem addGas;

    @FXML
    private AnchorPane inputPane;

    private Thread runner;
    @FXML
    void keyHandler(ActionEvent event) {
    }

    private void display(){
        try {
            while (true) {
                updateMPH();
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
        System.out.println("interrupt caught\n");
        }
    }

    private void updateMPH(){
        Double mph = Double.parseDouble(mphDisplay.getText());

        mph *= 1.1;
        if(mph > 80){
            mph = 30.0;
        }

        Date date = new Date();
        mphDisplay.setText(mph.toString());
    }

    public HomeMenu(){
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        mphChart.getXAxis().setAutoRanging(true);
        mphChart.getYAxis().setAutoRanging(true);

        runner = new Thread(this::display);
        runner.start();
    }

    @FXML
    void resetTrip(ActionEvent event) {
        tripDisplay.setText("0");
        //todo reset trip value to 0 where it is saved
    }

    @FXML
    void loadSettings(ActionEvent event) {

    }

    private Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

    @FXML
    void loadGasMenu(ActionEvent event) {
        Stage stage = (Stage) inputPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/GasMenu.fxml"));
        GridPane pane;
        try {
            pane = loader.load();
        } catch (Throwable e) {
            e.printStackTrace();
            return;
        }
        stage.getScene().setRoot(pane);
        stage.setTitle("Gas Input");
        runner.interrupt();

    }

}

