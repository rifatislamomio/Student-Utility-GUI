import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class GetHelpSendMessage implements Initializable {

    @FXML
    Label selectedPerson;
    @FXML
    TextArea message;
    @FXML
    Button sendButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        message.setPromptText("!YOU CAN SEND ONLY ONE MESSAGE!");

        selectedPerson.setText(GetHelp.selectedPerson);
    }


    @FXML
    private void sendClicked() throws Exception {
        sendButton.setText("Sent!");
        sendButton.setDisable(true);

        int serial = CommonMethods.mySerialGetter(GetHelp.selectedPerson);

        DataB.manipulateDb(DataB.con,"INSERT INTO messages (user"+serial+",user"+(3-serial)+",user"+serial+"message) VALUES ('"+showMessenger.userName+"','"+GetHelp.selectedPerson+"','"+message.getText()+"')");


        /**Save the MESSAGE and RECIEVER USERNAME into user's device file**/
        DataOutputStream output = new DataOutputStream(new FileOutputStream(GetHelp.selectedPerson+".dat"));
        output.writeUTF("You-"+message.getText()+"\n\n");
        output.close();

        output = new DataOutputStream(new FileOutputStream("AllFriends.dat",true));
        output.writeUTF(GetHelp.selectedPerson);
        output.close();


    }
}
