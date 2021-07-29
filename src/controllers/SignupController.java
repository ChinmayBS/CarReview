package controllers;

import backend.CSVLoader;
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
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.regex.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    @FXML
    public JFXRadioButton female;
    public JFXRadioButton male;

    public Label labelMessage;

    @FXML
    AnchorPane pane;

    @FXML
    private JFXTextField usernameText;

    @FXML
    private JFXTextField locationText;

    @FXML
    private ToggleGroup genderToggleGroup;

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
       || (!male.isSelected() && !female.isSelected())|| locationText.getText().isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("please enter all the details: ");
            alert.setContentText("Make sure you entered name, password, gender, and location correctly");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    private boolean validateName(){               //name should contain only letters numbers and underscores
        if(!(usernameText.getText().matches("[A-Za-z0-9_]+")) )
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Username should only contain: ");
            alert.setContentText("1. Letters\n2. Numbers/Underscore");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    private boolean validatePassword(){            //suggest strong password using regular expression

        int iPasswordScore = 0;
        String password = passwordText.getText();

        if( password.length() >= 8 )
            iPasswordScore += 2;
        else
            iPasswordScore += 1;

        //if it contains one digit, add 2 to total score
        if( password.matches("(?=.*[0-9]).*") )
            iPasswordScore += 2;

        //if it contains one lower case letter, add 2 to total score
        if( password.matches("(?=.*[a-z]).*") )
            iPasswordScore += 2;

        //if it contains one upper case letter, add 2 to total score
        if( password.matches("(?=.*[A-Z]).*") )
            iPasswordScore += 2;

        //if it contains one special character, add 2 to total score
        if( password.matches("(?=.*[~!@#$%^&*()_-]).*") )
            iPasswordScore += 2;

        if(iPasswordScore!=10)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Entered password is weak ");
            alert.setContentText("Requirements for a password:\n1. Least 8 characters long \n2. At least one Upper case " +
                    "and lower case\n3. At least One special character.");
            alert.showAndWait();
            return false;
        }
        return true;
    }


    @FXML
    void signup(ActionEvent event) throws IOException {
        if(validateFields() && validateName() && validatePassword()){
            System.out.println("sign up success");
            String username=usernameText.getText();
            String password=passwordText.getText();
            String location=locationText.getText();
            String gender;
            if(male.isSelected()){
                gender="male";
            }
            else{
                gender="female";
            }
            CSVLoader csvLoader = new CSVLoader();
            csvLoader.updateSignupDetails(username+","+password+","+gender+","+location+","+0);
            labelMessage.setText("Account Created Successfully");                 //display message on screen that account is successfully created

            usernameText.clear();                    //clear the fields after successful sign up
            passwordText.clear();
            locationText.clear();
            genderToggleGroup.selectToggle(null);



        }
        else{
            //System.out.println("sign up failed");
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
