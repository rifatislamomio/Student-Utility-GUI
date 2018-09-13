import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class showTime {
    public static Stage primaryStage = new Stage();
    public static void show()
    {
        try{
            Parent root = null;
            try {
                root = FXMLLoader.load(Main.class.getResource("mainPanel.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            primaryStage.setTitle("Countdown Timer");
            Scene scene = new Scene(root);
            primaryStage.getIcons().add(new Image("timer.png"));
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
