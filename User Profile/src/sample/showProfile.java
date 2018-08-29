package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class showProfile {
    public static Stage primaryStage = new Stage();

    public static void show()
    {
        try{
            FXMLLoader loader = new FXMLLoader(showProfile.class.getResource("userProfile.fxml"));

            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Profile");
            primaryStage.getIcons().add(new Image(showProfile.class.getResourceAsStream("user.png")));
            primaryStage.setAlwaysOnTop(true);
            primaryStage.setAlwaysOnTop(true);
            primaryStage.show();


        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
