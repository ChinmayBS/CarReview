package controllers;

import backend.CarDetailsLoader;
import backend.LoadComponents;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
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

    ArrayList<Image> images;

    int i=0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        contactDetails.setVisible(false);
        String currCarName = LoadComponents.getUniqueCarName();
        System.out.println(LoadComponents.getUniqueCarName());
        CarDetailsLoader carDetailsLoader=new CarDetailsLoader("src/resources/files/cardetails.csv");
        ArrayList<String[] > cars=carDetailsLoader.getCarDetails();
        for(String[] entity:cars){
            if(entity[0].equals(currCarName)){
                setTextFields(entity);
            }
        }
        imageView.setImage(images.get(0));
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
        images=new ArrayList<>();
        for(int i=11;i<15;i++){
            images.add(new Image(entity[i]));
            System.out.println(entity[i]);
        }
    }

    @FXML
    void addToCart(ActionEvent event) {
        History.AddCarsToCart(carName.getText());
        //HomePageController.increaseCartCartSize();
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
    public void previousImage(ActionEvent actionEvent) {
        i=(i+1)%images.size();
        System.out.println(i);
        imageView.setImage(images.get(i));
    }

    public void nextImage(ActionEvent actionEvent) {
        i=(i-1+images.size())%images.size();
        System.out.println(i);
        imageView.setImage(images.get(i));
    }
}
