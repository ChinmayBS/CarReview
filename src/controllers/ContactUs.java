package controllers;


import backend.LoadComponents;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ContactUs extends LoadComponents{

    public ImageView home;

    @FXML
    void goToGiHubChinmay(MouseEvent event) {

    }

    @FXML
    void goToGitHubAvshet(MouseEvent event) {

    }

    @FXML
    void goToHome(MouseEvent event) {
        LoadComponents.closeWindow(home);
        LoadComponents.displayWindow("../fxml/homepage.fxml");
    }

}
