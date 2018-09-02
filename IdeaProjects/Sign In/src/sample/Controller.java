package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField pass;



    private PreparedStatement preparedStatement;


    public void getStarted(ActionEvent acc)
    {

        try{
            Connection con = ConnectionConfig.getConnection();

             String sql = "SELECT *FROM userdetails WHERE " +
                "UserName='"+username.getText()+"' AND Pass = '"+pass.getText()+"'";

            ResultSet resultSet =  con.prepareStatement(sql).executeQuery();

            if(resultSet.next())
            {
                System.out.println("Success!");
            }
            else
            {
                errorPass.showBox();
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }



    }

    public void close(ActionEvent acc)
    {

        Platform.exit();

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
