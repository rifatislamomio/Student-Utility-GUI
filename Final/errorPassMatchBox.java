import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class errorPassMatchBox {
    public static Stage abStage = new Stage();
    public static void showBox() {

        try {
            FXMLLoader alertbox = new FXMLLoader(errorPassMatchBox.class.getResource("errorPassMatchBox.fxml"));

            AnchorPane pane = alertbox.load();
            Scene scene = new Scene(pane);
            abStage.setScene(scene);
            abStage.setResizable(false);
            abStage.setAlwaysOnTop(true);
            abStage.setTitle("Password Error!");
            abStage.getIcons().add(new Image(errorPassMatchBox.class.getResourceAsStream("error.png")));
            abStage.show();


        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
