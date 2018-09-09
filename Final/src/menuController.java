import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class menuController {

    public void exit(ActionEvent e)
    {
        Platform.exit();
    }

    public void about(ActionEvent e)
    {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
        AnchorPane pane = null;
        try {
            pane = fxmlLoader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Stage stg = new Stage();
            stg.setTitle("About");
            stg.setScene(new Scene(pane));
            stg.setResizable(true);
            stg.setAlwaysOnTop(true);
            //stg.initModality(Modality.APPLICATION_MODAL);
            stg.show();
    }

    public void home(ActionEvent e)
    {
        {
            showNote.primaryStage.close();
            showMenu.primaryStage.close();
            showCalculator.primaryStage.close();
            showTime.primaryStage.close();
            showProfile.primaryStage.close();
            showSignIN.show();
        }
    }

    public void userInfo(ActionEvent e)
    {

        showProfile.show();
    }

    public void messenger(ActionEvent e)
    {
        showMessenger.show();
        showMenu.primaryStage.close();

    }

    public void calculator(ActionEvent e)
    {
        showCalculator.show();

    }

    public void note(ActionEvent e)
    {
        showNote.show();
    }



    public void timer(ActionEvent e)
    {
        showTime.show();

    }


}
