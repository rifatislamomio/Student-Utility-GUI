import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class StartPoint implements Initializable {
    @FXML
    Button chatButton;
    @FXML
    Button getHelpButton;
    @FXML
    ImageView overchat;
    @FXML
    ImageView overfindothers;
    @FXML
    ImageView background;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection startPoint = DataB.getDbConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void chatButtonPressed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Stage stage = new Stage();
        Parent root = loader.load();
        stage.setTitle("Chat Window");
        stage.setScene(new Scene(root, 565 , 493));
        stage.setAlwaysOnTop(true);
        stage.getIcons().add(new Image("/Messenger-icon.png"));

        stage.show();

        stage.setOnCloseRequest(event -> {
            Controller c = loader.getController();
            c.closeByX();
            stage.close();
        });
    }

    @FXML
    private void getHelpButtonPressed() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("getHelpDesign.fxml"));
        stage.setTitle("Search Window");
        stage.setScene(new Scene(root, 565 , 493));
    stage.setAlwaysOnTop(true);
        stage.getIcons().add(new Image("/search.png"));

        stage.show();

    }


}
