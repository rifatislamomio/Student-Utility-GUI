package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("userProfile.fxml"));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Profile");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("user.png")));

        primaryStage.setAlwaysOnTop(true);

        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }



}
