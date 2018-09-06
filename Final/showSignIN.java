import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class showSignIN {
    public static Stage stage = new Stage();

    public static void show()
    {
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("signIn.fxml"));

            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());
            try {
                stage.initStyle(StageStyle.UNDECORATED);
            }catch (Exception e)
            {

            }
            stage.setAlwaysOnTop(true);


            stage.setResizable(false);
            stage.setTitle("Sign In");
            stage.setScene(scene);
            stage.show();

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
