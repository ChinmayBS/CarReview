package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    @FXML
    public JFXRadioButton female;
    public JFXRadioButton male;

    @FXML
    AnchorPane pane;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField location;

    @FXML
    private ToggleGroup gender;

    @FXML
    private JFXButton signupButton;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton loginButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void signup(ActionEvent event) {

    }

    @FXML
    void login(ActionEvent event) throws IOException {
        signupButton.getScene().getWindow().hide();
        //relative path for loading fxml
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        Stage loginStage=new Stage();
        loginStage.setScene(new Scene(root,800,500) );
        loginStage.show();
        loginStage.setResizable(false);
    }


}
