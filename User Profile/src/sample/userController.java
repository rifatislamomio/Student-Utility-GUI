package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class userController {

    public void close(ActionEvent e)
    {
        Platform.exit();

    }

}
