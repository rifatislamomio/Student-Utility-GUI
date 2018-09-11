import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("browser.fxml"));
        primaryStage.setTitle("Web Surfer");
        AnchorPane pane = loader.load();
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("internet.png"));
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
