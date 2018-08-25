package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class showProfile {
    public static void show()
    {
        try{
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(showProfile.class.getResource("userProfile.fxml"));

            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Profile");
            primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("user.png")));
            primaryStage.setAlwaysOnTop(true);


            primaryStage.show();


        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
