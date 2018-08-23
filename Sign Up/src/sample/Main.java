package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Sign Up");
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("user.png")));

        primaryStage.show();




        if(ConnectionConfig.getConnection()==null)
        {
            errorConnectionBox.showBox();
        }
        else
        {
            System.out.println("Successfully connected with server!");
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
