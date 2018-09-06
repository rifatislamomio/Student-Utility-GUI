import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class signUpController implements Initializable {

    public void aboutButton(ActionEvent bt)
    {
        try
        {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
            AnchorPane pane = fxmlLoader.load();
            Stage stg = new Stage();
            stg.setTitle("About");
            stg.setScene(new Scene(pane));
            stg.setResizable(true);
            stg.setAlwaysOnTop(true);
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.show();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }


    @FXML
    private JFXTextField fName;

    @FXML
    private JFXTextField lName;

    @FXML
    private JFXTextField uName;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField sID;

    @FXML
    private JFXPasswordField pass;




    public void signUp(ActionEvent sa)
    {
        Connection connection =null;
        try{

            connection = ConnectionConfig.getConnection();
            if(connection!=null)
            {
                System.out.println("Established");
                Statement uDet = connection.createStatement();

                String sql = "INSERT into users" +
                        "(firstname, lastname,id,email,username,password,department)"+
                        "values('"+fName.getText()+"','"+lName.getText()+"','"+sID.getText()+"','"+email.getText()+"','"+uName.getText()+"','"+pass.getText()+"','"+idGetter.getDept(sID.getText())+"')";


                uDet.executeUpdate(sql);
                successAlertBox.showBox();
            }
            else
            {
                System.out.println("Failed");
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }


    public void signIn(ActionEvent event)
    {
        showSignIN.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
