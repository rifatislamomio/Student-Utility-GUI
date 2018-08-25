package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class testFrameController {

    @FXML
    private JFXTextField testID;

    public void show(ActionEvent e)
    {
        idGetter.setID(testID.getText());
        showProfile.show();
    }

}
