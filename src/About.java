import javafx.event.ActionEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class About {

    public void devOne(ActionEvent e)
    {
        try {
            Desktop.getDesktop().browse(new URI("http://fb.com/omio89"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
    }

    public void devTwo(ActionEvent e)
    {
        try {
            Desktop.getDesktop().browse(new URI("http://www.facebook.com/Fislam.0306"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
    }
}
