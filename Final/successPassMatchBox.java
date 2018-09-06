import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class successPassMatchBox {
    public static void showBox() {


        try {
            FXMLLoader alertbox = new FXMLLoader(successPassMatchBox.class.getResource("successPassMatchBox.fxml"));
            Stage abStage = new Stage();
            AnchorPane pane = alertbox.load();
            Scene scene = new Scene(pane);
            abStage.setScene(scene);
            abStage.setResizable(false);
            abStage.setTitle("SUCCESS!");
            abStage.setAlwaysOnTop(true);
            abStage.initModality(Modality.APPLICATION_MODAL);
            abStage.getIcons().add(new Image(successPassMatchBox.class.getResourceAsStream("success.png")));
            abStage.show();
        } catch (Exception e) {

        }
    }

}
