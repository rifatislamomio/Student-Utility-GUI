import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class testFrameController {

    @FXML
    private JFXTextField testID;

    public void show(ActionEvent e) {
        idGetter.setID(testID.getText());
        showProfile.show();
    }
}


