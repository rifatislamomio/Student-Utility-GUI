import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
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
    private Label department;

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

        String nm="null",ID="null",usrname="null",eml="null",dept="null";
        try {
            Connection connection = ConnectionConfig.getConnection();
            Statement myst = connection.createStatement();
            ResultSet resultSet = myst.executeQuery("SELECT *from users where users.id = "+sqlID+"");
            resultSet.next();
            nm =(resultSet.getString("firstname")+" "+resultSet.getString("lastname"));
            usrname = (resultSet.getString("username"));
             ID = (resultSet.getString("id"));
            eml =(resultSet.getString("email"));
            idGetter.setUserPass(resultSet.getString("password"));
            dept = resultSet.getString("department");

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
        department.setText(dept);

    }




}
