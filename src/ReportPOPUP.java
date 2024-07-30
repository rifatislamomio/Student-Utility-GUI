import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class ReportPOPUP {
    @FXML Button yes,no;
    @FXML Label alertMessage;

    @FXML private void yesClicked() throws IOException {
        //Report sent to database
        Stage stage = (Stage)yes.getScene().getWindow();
        stage.close();
    }

    @FXML private void noClicked(){
       //Report sent to database
        Stage stage = (Stage)yes.getScene().getWindow();
        stage.close();
    }

}
