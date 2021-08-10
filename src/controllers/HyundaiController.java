package controllers;

import backend.LoadComponents;
import com.jfoenix.  controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HyundaiController extends LoadComponents {

    public ImageView exitButton;
    @FXML
    private VBox menuVBox;

    @FXML
    private HBox menuHBox1;

    @FXML
    private JFXButton carSpace1;

    @FXML
    private ImageView menuImageView1;

    @FXML
    private JFXButton carSpace2;

    @FXML
    private ImageView menuImageView2;

    @FXML
    private HBox menuHBox2;

    @FXML
    private JFXButton carSpace3;

    @FXML
    private ImageView menuImageView3;

    @FXML
    private JFXButton carSpace4;

    @FXML
    private ImageView menuImageView4;


    @FXML
    void goToCar2(ActionEvent event) {

    }

    @FXML
    void goToCar3(ActionEvent event) {

    }

    @FXML
    void goToCar4(ActionEvent event) {

    }

    @FXML
    void goToHome(MouseEvent event)  {
        LoadComponents.closeWindow(exitButton);
        LoadComponents.displayWindow("../fxml/homepage.fxml");
    }

    @FXML
    void goToCar1(ActionEvent event) {
        System.out.println(carSpace1.getText());
        LoadComponents.setUniqueCarName(carSpace1.getText());
        LoadComponents.closeWindow(carSpace1);
        LoadComponents.displayWindow("../fxml/detail.fxml");
    }

}

