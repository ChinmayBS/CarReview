package controllers;

import backend.LoadComponents;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuController extends LoadComponents {


    @FXML
    private VBox menuVBox;

    @FXML
    private HBox menuHBox1;

    @FXML
    private JFXButton suzukiButton;


    @FXML
    private JFXButton hyundaiButton;


    @FXML
    private JFXButton toyotaButton;


    @FXML
    private JFXButton tataButton;

    @FXML
    void openHyundai(ActionEvent event)  {
        LoadComponents.closeWindow(hyundaiButton);
        LoadComponents.displayWindow("../fxml/hyundai.fxml");
    }

    @FXML
    void openSuzuki(ActionEvent event) {
        LoadComponents.closeWindow(suzukiButton);
        LoadComponents.displayWindow("../fxml/maruthi.fxml");
    }

    @FXML
    void openTata(ActionEvent event) {
        LoadComponents.closeWindow(tataButton);
        LoadComponents.displayWindow("../fxml/tata.fxml");
    }

    @FXML
    void openToyota(ActionEvent event)  {
        LoadComponents.closeWindow(tataButton);
        LoadComponents.displayWindow("../fxml/toyota.fxml");
    }

}
