import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;


public class browserController implements Initializable {



    @FXML
    private ComboBox comboBox;

    @FXML
    private JFXTextField addressbar;


    @FXML
    private WebView web;
    WebEngine engine;

    String http = "http://";
    String link;


    public void Go(ActionEvent e)
    {
        link = addressbar.getText();
        engine = web.getEngine();
        engine.load(http+link);


    }


    public void comboAction()
    {
        if(comboBox.getValue().toString().equals("Github"))
        {
            engine.load(http+"github.com");
        }
        else if(comboBox.getValue().toString().equals("RDS"))
        {
            engine.load(http+"rds3.northsouth.edu");
        }
        else if(comboBox.getValue().toString().equals("Facebook"))
        {
            engine.load(http+"fb.com");
        }

        else if(comboBox.getValue().toString().equals("Youtube"))
        {
            engine.load(http+"youtube.com");
        }

        else if(comboBox.getValue().toString().equals("Stackoverflow"))
        {
            engine.load(http+"Stackoverflow.com");
        }
        else if(comboBox.getValue().toString().equals("Lynda"))
        {
            engine.load(http+"lynda.com");
        }

    }

    public void goBack(ActionEvent e)
    {

        Platform.runLater(() -> {
            engine.executeScript("history.back()");
        });
    }

    public void goForward(ActionEvent e)
    {

        Platform.runLater(() -> {
            engine.executeScript("history.forward()");
        });
    }

    public void reload(ActionEvent e)
    {
        engine.reload();
    }

    public void home(ActionEvent e)
    {
        engine.load(http+"www.google.com/intl/en_uk");
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        engine = web.getEngine();
        engine.load(http+"www.google.com/intl/en_uk");
        comboBox.getItems().addAll("RDS","Github","Stackoverflow","Facebook","Youtube","Lynda");

        addressbar.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER)  {
                    link = addressbar.getText();
                    engine = web.getEngine();
                    engine.load(http+link);
                }
            }
        });
    }
}

