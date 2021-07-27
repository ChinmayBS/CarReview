package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXButton signupButton;

    @FXML
    private JFXCheckBox remember;

    @FXML
    private JFXButton forgotPassword;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void login(ActionEvent event) {

    }

    @FXML
    void signup(ActionEvent event) throws IOException {
        loginButton.getScene().getWindow().hide();
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/signup.fxml"));
        Stage signupStage=new Stage();
        signupStage.setScene(new Scene(root,800,500) );
        signupStage.show();
        signupStage.setResizable(false);
    }

}
