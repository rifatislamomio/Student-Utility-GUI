import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class showCalculator {
    public static Stage primaryStage = new Stage();
    public static void show()
    {
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("calculator.fxml"));

            AnchorPane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Scene scene = new Scene(pane);
            primaryStage.setTitle("Calculator");
            try {
                primaryStage.initStyle(StageStyle.UNDECORATED);
            }catch (Exception e)
            {

            }
            primaryStage.setScene(scene);
            primaryStage.setAlwaysOnTop(true);
            primaryStage.show();

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
