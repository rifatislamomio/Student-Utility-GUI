package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;

public class AlertBox {

    public static void showBox() {


        try {
            FXMLLoader alertbox = new FXMLLoader(AlertBox.class.getResource("AlertBox.fxml"));
            Stage abStage = new Stage();
            AnchorPane pane = alertbox.load();
            Scene scene = new Scene(pane);
            abStage.setScene(scene);
            abStage.setResizable(false);
            abStage.setTitle("ERROR!");
            abStage.initModality(Modality.APPLICATION_MODAL);
            abStage.getIcons().add(new Image(AlertBox.class.getResourceAsStream("error.png")));

            abStage.show();

        } catch (Exception e) {

        }
    }




}
