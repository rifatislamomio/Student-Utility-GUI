package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXButton btn;

    public void getStarted(ActionEvent acc)
    {
        if(username.getText().equals("omio") && pass.getText().equals("qwe"))
        {
            System.out.println("Login In");
            btn.setText("Login In");
            btn.setDisable(true);
        }
        else
        {
            System.out.println("Wrong Password");

            AlertBox.showBox();
        }


    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
