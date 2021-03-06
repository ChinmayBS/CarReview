package controllers;

import backend.LoadComponents;
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

public class HomePageController extends LoadComponents implements Initializable {

    public JFXButton logoutButton;
    public JFXButton exitButton;
    public AnchorPane popUp;
    @FXML
    private  Label dashboardButton;

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
    private AnchorPane holderPane;

    private static int cartSize=0;
    public static void setCartCartSize(int value){
        cartSize=value;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        popUp.setVisible(false);
        totalcarsLabel.setText(String.valueOf(cartSize));
        String userName=LoginController.getUserName();
        welcomeLabel.setText(welcomeLabel.getText()+" "+userName);
    }

    @FXML
    void contactUs(ActionEvent event) {
        LoadComponents.closeWindow(contactButton);
        LoadComponents.displayWindow("../fxml/contactus.fxml");
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        Parent root=LoadComponents.getRoot("../fxml/menu.fxml");
        holderPane.getChildren().add(root);
    }

    @FXML
    void myCarsList(ActionEvent event) {

    }

    @FXML
    void myHistory(ActionEvent event) {
        LoadComponents.closeWindow(historyButton);
        LoadComponents.displayWindow("../fxml/history.fxml");
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
        stage.setTitle("Car Review");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

}
