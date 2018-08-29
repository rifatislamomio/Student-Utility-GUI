package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class userController implements Initializable {


    public void close(ActionEvent e)
    {
        showProfile.primaryStage.close();
    }

    public void Update(ActionEvent ee)
    {
        userUpdate.show();
    }


    @FXML
    private  Label name;

    @FXML
    private Label uName;

    @FXML
    private Label id;

    @FXML
    private Label email;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String sqlID = idGetter.getID();

        String nm="null",ID="null",usrname="null",eml="null";
        try {
            Connection connection = ConnectionConfig.getConnection();
            Statement myst = connection.createStatement();
            ResultSet resultSet = myst.executeQuery("SELECT *from userdetails where userdetails.ID = "+sqlID+"");
            resultSet.next();
            nm =(resultSet.getString("FirstName")+" "+resultSet.getString("LastName"));
            usrname = (resultSet.getString("UserName"));
             ID = (resultSet.getString("ID"));
            eml =(resultSet.getString("Email"));
            idGetter.setUserPass(resultSet.getString("Pass"));

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        idGetter.setUsername(nm);
        idGetter.setUserMail(eml);
        idGetter.setUsername(usrname);

        name.setText(nm);
        uName.setText(usrname);
        id.setText(ID);
        email.setText(eml);
    }




}
