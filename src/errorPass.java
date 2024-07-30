import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class errorPass {

    public static void showBox() {


        try {
            FXMLLoader alertbox = new FXMLLoader(errorPass.class.getResource("errorPass.fxml"));
            Stage abStage = new Stage();
            AnchorPane pane = alertbox.load();
            Scene scene = new Scene(pane);
            abStage.setScene(scene);
            abStage.setResizable(false);
            abStage.setTitle("ERROR!");
            abStage.setAlwaysOnTop(true);
            abStage.getIcons().add(new Image(errorPass.class.getResourceAsStream("error.png")));

            abStage.show();

        } catch (Exception e) {

        }
    }




}
