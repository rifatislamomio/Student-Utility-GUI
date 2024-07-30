import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class successEmailBox {
    public static void showBox() {


        try {
            FXMLLoader alertbox = new FXMLLoader(successEmailBox.class.getResource("successEmailBox.fxml"));
            Stage abStage = new Stage();
            AnchorPane pane = alertbox.load();
            Scene scene = new Scene(pane);
            abStage.setScene(scene);
            abStage.setResizable(false);
            abStage.setTitle("SUCCESS!");
            abStage.setAlwaysOnTop(true);
            abStage.getIcons().add(new Image(successEmailBox.class.getResourceAsStream("success.png")));

            abStage.show();

        } catch (Exception e) {

        }
    }

}
