package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/homepage.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("../fxml/signup.fxml"));
        primaryStage.setTitle("Car Review");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();


    }


    public static void main(String[] args) throws IOException {
       launch(args);
    }
}
