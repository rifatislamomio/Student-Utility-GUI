package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

   public Stage stage;



    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = primaryStage;
        mainWindow();

}


    public void mainWindow()
    {

        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml"));

            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setAlwaysOnTop(true);


            stage.setResizable(false);
            stage.setTitle("Sign In");
            stage.setScene(scene);
            stage.show();





        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public static void main(String[] args) {
        launch(args);
    }
}
