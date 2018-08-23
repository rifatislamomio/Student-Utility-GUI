package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class errorConnectionBox {
    public static void showBox() {

        try {
            FXMLLoader alertbox = new FXMLLoader(errorConnectionBox.class.getResource("errorConnectionBox.fxml"));
            Stage abStage = new Stage();
            AnchorPane pane = alertbox.load();
            Scene scene = new Scene(pane);
            abStage.setScene(scene);
            abStage.setResizable(false);
            abStage.setTitle("Connection Error!");
            abStage.initModality(Modality.APPLICATION_MODAL);
            abStage.getIcons().add(new Image(errorConnectionBox.class.getResourceAsStream("error.png")));
            abStage.show();
            abStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

                public void handle(WindowEvent t) {
                    Platform.exit();
                    System.exit(0);
                }
            });

        } catch (Exception e) {

        }
    }



}
