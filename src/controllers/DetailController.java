package controllers;

import backend.CarDetailsLoader;
import backend.LoadComponents;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DetailController extends LoadComponents implements Initializable {

    @FXML
    private JFXButton contactOwnerButton;

    @FXML
    private JFXButton addToCartButton;

    @FXML
    private ImageView imageView;

    @FXML
    private Label carName;

    @FXML
    private ImageView exitButton;

    @FXML
    private Label brand;

    @FXML
    private Label model;

    @FXML
    private Label variant;

    @FXML
    private Label year;

    @FXML
    private Label fuel;

    @FXML
    private Label transmission;

    @FXML
    private Label kmDriven;

    @FXML
    private Label noOfOwners;

    @FXML
    private Label whatsapp;

    @FXML
    private Label message;

    @FXML
    private JFXButton rightButton;

    @FXML
    private JFXButton leftButton;

    @FXML
    HBox contactDetails;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        contactDetails.setVisible(false);

        String currCarName="oldolxcar";
        CarDetailsLoader carDetailsLoader=new CarDetailsLoader("src/resources/files/cardetails.csv");
        ArrayList<String[] > cars=carDetailsLoader.getCarDetails();
        for(String[] entity:cars){
            if(entity[0].equals(currCarName)){
                setTextFields(entity);
            }
        }

    }

    private void setTextFields(String[] entity){
        carName.setText(entity[0]);
        brand.setText(entity[1]);
        model.setText(entity[2]);
        variant.setText(entity[3]);
        year.setText(entity[4]);
        fuel.setText(entity[5]);
        transmission.setText(entity[6]);
        kmDriven.setText(entity[7]);
        noOfOwners.setText(entity[8]);
        message.setText(entity[9]);
        whatsapp.setText(entity[10]);
    }

    @FXML
    void addToCart(ActionEvent event) {

    }

    @FXML
    void contactOwner(ActionEvent event) {
        contactDetails.setVisible(!contactDetails.isVisible());
    }

    @FXML
    void goToHome(MouseEvent event) {
        LoadComponents.closeWindow(exitButton);
        LoadComponents.displayWindow("../fxml/homepage.fxml");
    }
}
