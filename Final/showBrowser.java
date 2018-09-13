import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class showBrowser {
    public static Stage primaryStage = new Stage();

    public static void show(){
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("browser.fxml"));

            AnchorPane pane = loader.load();
            primaryStage.setFullScreen(false);
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image("internet.png"));
            Scene scene = new Scene(pane);
            primaryStage.setAlwaysOnTop(true);
            primaryStage.setTitle("Web Surfer");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
