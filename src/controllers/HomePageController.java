package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    public JFXButton logoutButton;
    public JFXButton exitButton;
    public AnchorPane popUp;
    @FXML
    private Label dashboardButton;

    @FXML
    private JFXButton homeButton;

    @FXML
    private JFXButton mycarsButton;

    @FXML
    private JFXButton historyButton;

    @FXML
    private JFXButton contactButton;

    @FXML
    private Label totalcarsLabel;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button popupButton;


    @FXML
    public AnchorPane holderPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        popUp.setVisible(false);
    }

    @FXML
    void contactUs(ActionEvent event) {

    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/menu.fxml"));
        holderPane.getChildren().add(root);
    }

    @FXML
    void myCarsList(ActionEvent event) {

    }

    @FXML
    void myHistory(ActionEvent event) {

    }

    @FXML
    void popUpWindow(MouseEvent event) {
        if(popUp.isVisible()){
            popUp.setVisible(false);
        }
        else{
            popUp.setVisible(true);
        }

    }

    public void logoutScreen(ActionEvent actionEvent) throws IOException {
        logoutButton.getScene().getWindow().hide();

        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("../fxml/signup.fxml"));
        stage.setTitle("Car Review");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

}
