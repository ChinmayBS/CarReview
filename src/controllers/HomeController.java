package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class HomeController extends HomePageController {

    @FXML
    private JFXButton hyundai;

    @FXML
    static void openHyundai(ActionEvent event) throws IOException {
        System.out.println("HI");
        //HomePageController.details();
        //Parent root = FXMLLoader.load(getClass().getResource("../fxml/details.fxml"));
        //holderPane2.getChildren().add(root);
    }

}
