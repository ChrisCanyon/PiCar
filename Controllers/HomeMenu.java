package PiCar.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class HomeMenu {


    //FXML items
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
    private ProgressBar fuelGauge;

    @FXML
    private LineChart<?, ?> mphChart;

    @FXML
    private MenuButton settingMenu;

    @FXML
    private MenuItem addGas;

    @FXML
    private AnchorPane inputPane;

    //Other Variables

    private Thread UIUpdateTimer;

    private Runnable displayRunnable;

    private double mpg = 20;

    private double tankSize = 20;

    private double trip;

    private DecimalFormat df = new DecimalFormat(".##");


    private double milesTravelled;
    //Non FXML functions

    public HomeMenu(){

        Runnable init = this::init;
        //todo get saved for milesTravelled, mpgDisplay, tripDisplay...
        milesTravelled = 135;
        trip = 135;

        UIUpdateTimer = new Thread(this::updateTimer);
        displayRunnable = this::updateUI;
        UIUpdateTimer.setName("Update Timer");
        Platform.runLater(init);
        UIUpdateTimer.start();
    }

    private void init(){
        //todo set values for mpg
        mpgDisplay.setText(df.format(mpg));
        tripDisplay.setText(df.format(trip));
    }

    private void updateTimer(){
        try {
            while (true) {
                Platform.runLater(displayRunnable);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("interrupt caught\n");
        }
    }

    private void updateUI(){
        updateDistance();
        updateFuelGauge();
        updateMPH();
    }

    //todo use gps inputs
    private void updateMPH(){
        Double mph = Double.parseDouble(mphDisplay.getText());

        mph += 1.23;
        if(mph > 80.0){
            mph = 30.0;
        }
        mphDisplay.setText(df.format(mph));
    }

    private void updateFuelGauge(){
        double fuelLevel = (mpg * tankSize - milesTravelled) / (mpg * tankSize);
        fuelGauge.setProgress(fuelLevel);
        if(fuelLevel > .5) {
            fuelGauge.setStyle("-fx-accent: #10ff00");
        } else if (fuelLevel > .35){
            fuelGauge.setStyle("-fx-accent: yellow");
        } else if (fuelLevel > .2) {
            fuelGauge.setStyle("-fx-accent: orange");
        } else {
            fuelGauge.setStyle("-fx-accent: red");
        }
    }


    //todo get data from gps
    private void updateDistance(){
        double delta = .1;
        milesTravelled += delta;
        trip += delta;

        tripDisplay.setText(df.format(trip));
    }

    //FXML Functions
    @FXML
    void keyHandler(ActionEvent event) {
    }

    @FXML
    void resetTrip() {
        trip = 0;
        tripDisplay.setText("0");
        //todo reset trip value to 0 where it is saved
    }

    @FXML
    void loadSettings(ActionEvent event) {

    }

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
        UIUpdateTimer.interrupt();

    }

}

