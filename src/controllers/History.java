package controllers;

import backend.LoadComponents;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class History extends LoadComponents implements Initializable {

    public VBox vbox;

    @FXML
    private ImageView homeButton;

    private static LinkedList<String> cars=new LinkedList<>();
    private static HashSet<String> uniqueCars=new HashSet<>();
    private static final int  MAX_CARS=6;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i=0;
        for(String car:cars){
            addCarToVbox(car,++i);
        }
    }

    private void addCarToVbox(String car,int i) {
        Label label=new Label(i+". "+car);
        label.setPrefWidth(280.0);
        label.setPrefHeight(30.0);
        vbox.getChildren().add(label);
    }


    public static void AddCarsToCart(String carName){
        if(uniqueCars.size()<4){
            if(!uniqueCars.contains(carName)){
                uniqueCars.add(carName);
                cars.add(carName);
            }
        }
        else{
            if(!uniqueCars.contains(carName)){
                uniqueCars.add(carName);
                cars.remove(0);
                cars.add(carName);
            }
        }
        HomePageController.setCartCartSize(uniqueCars.size());
    }






    @FXML
    void goToHome(MouseEvent event) {
        LoadComponents.closeWindow(homeButton);
        LoadComponents.displayWindow("../fxml/homepage.fxml");
    }




}
