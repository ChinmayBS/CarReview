package controllers;

import backend.CSVLoader;
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
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public ImageView carImageView;
    @FXML
    private JFXTextField usernameText;

    @FXML
    private JFXPasswordField passwordText;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXButton signupButton ;

    @FXML
    private JFXCheckBox remember;

    @FXML
    private JFXButton forgotPassword;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private boolean validateFields(){                         //make sure that all fields are filled
        if(usernameText.getText().isEmpty() || passwordText.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valid fields");
            alert.setHeaderText("please enter all the details: ");
            alert.setContentText("either password or name is not entered: ");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    @FXML
    void login(ActionEvent event) throws IOException {

        CSVLoader csvLoader = new CSVLoader();
        HashMap<String,String> loginMap=csvLoader.loadLoginDetails();

        String username,password;
        if(validateFields()) {
            username = usernameText.getText();
            password = passwordText.getText();

           boolean flag=false;
            for (Map.Entry element : loginMap.entrySet()) {                                        //username password key value pairs
                if (element.getKey().equals(username) && element.getValue().equals(password)) {
                    flag=true;
                    System.out.println("Welcome: " + username);
                }
            }
            if(!flag){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error: ");
                alert.setHeaderText("Wrong credentials");
                alert.showAndWait();
            }
          else{
               loginButton.getScene().getWindow().hide();
               //home page
                Parent root = FXMLLoader.load(getClass().getResource("../fxml/homepage.fxml"));
                Stage stage=new Stage();
                stage.setScene(new Scene(root,800,500));
                stage.show();
                stage.setResizable(false);

            }
        }

    }

    @FXML
    void signup(ActionEvent event) throws IOException {
        loginButton.getScene().getWindow().hide();
        //close current window
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/signup.fxml"));
        Stage signupStage=new Stage();
        signupStage.setScene(new Scene(root,800,500) );
        signupStage.show();
        signupStage.setResizable(false);

    }

}
