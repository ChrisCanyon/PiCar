package PiCar.Controllers;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

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

    @FXML
    void keyHandler(ActionEvent event) {

    }

    @FXML
    void resetTrip(ActionEvent event) {

    }

    @FXML
    void loadSettings(ActionEvent event) {

    }

    @FXML
    void loadGasMenu(ActionEvent event) {

    }

}

