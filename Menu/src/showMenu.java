import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class showMenu {
    public static Stage primaryStage = new Stage();
    public static void show()
    {
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("menuController.fxml"));
            AnchorPane pane  = loader.load();
            Scene scene = new Scene(pane);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setTitle("Menu");
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
