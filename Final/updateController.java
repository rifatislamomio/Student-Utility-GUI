import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class updateController implements Initializable {

    @FXML
    private Label name;

    @FXML
    private JFXTextField nEmail;

    @FXML
    private JFXButton uEmail;

    @FXML
    private JFXButton uPass;

    @FXML
    private JFXPasswordField nPass;

    @FXML
    private JFXTextField vPass;


    public void close(ActionEvent e)
    {
        userUpdate.updateStage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(idGetter.getUserName());
        nEmail.setText(idGetter.getUserMail());
        nPass.setText(idGetter.getUserPass());
    }

    public void updateEmail(ActionEvent e)
    {
        try {
            Connection connection = ConnectionConfig.getConnection();
            Statement myst = connection.createStatement();
            myst.executeUpdate("UPDATE users SET email='"+nEmail.getText() +"' where users.id = "+idGetter.getID());
            successEmailBox.showBox();

        }
        catch (Exception abc)
        {
            System.out.println(abc);
        }
    }


    public void updatePass(ActionEvent e)
    {
        String p1 = nPass.getText();
        String p2 = vPass.getText();

        if(p1.equals(p2)) {
            try {
                Connection connection = ConnectionConfig.getConnection();
                Statement myst = connection.createStatement();
                myst.executeUpdate("UPDATE users SET password='" + nPass.getText() + "' where usersusers.id = "+idGetter.getID());
                successPassMatchBox.showBox();

            } catch (Exception abc) {
                System.out.println(abc);
            }
        }
        else
        {
            errorPassMatchBox.showBox();
        }
    }

}
