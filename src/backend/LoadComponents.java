package backend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadComponents {
    static private String carName;
    protected static Parent getRoot(String path){
        Parent root= null;
        try {
            root = FXMLLoader.load(LoadComponents.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    protected static void displayWindow(String path){
        Parent root=LoadComponents.getRoot(path);
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    protected static void closeWindow(Node root){
        root.getScene().getWindow().hide();
    }

    public static void setUniqueCarName(String carName){
       LoadComponents.carName=carName;
    }

    public static String getUniqueCarName(){
        return carName;
    }

}
