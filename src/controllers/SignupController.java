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
import javafx.scene.control.Alert;
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
    private JFXTextField usernameText;

    @FXML
    private JFXTextField locationText;

    @FXML
    private ToggleGroup gender;

    @FXML
    private JFXButton signupButton;

    @FXML
    private JFXPasswordField passwordText;

    @FXML
    private JFXButton loginButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private boolean validateFields(){
        if(usernameText.getText().isEmpty() || passwordText.getText().isEmpty() || locationText.getText().isEmpty()
       || (!male.isSelected() && !female.isSelected()) ){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valid fields");
            alert.setHeaderText("please enter all the details: ");
            alert.setContentText("make sure you name,password,gender, and location");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    private boolean validateName(){               //name should contain only letters numbers and underscores
        //TODO :complete this method to name as per above comment
        //TODO: show alert (for more details refer validate fields methods
        return true;
    }
    private boolean validatePassword(){            //suggest strong password using regular expression
        //TODO: complete this method to accept strong password(use concept of regular expression)
        return true;
    }


    @FXML
    void signup(ActionEvent event) {
        if(validateFields() && validateName() && validatePassword()){
            System.out.println("sign up success");
        }
        else{
            System.out.println("sign up failed");
        }

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
