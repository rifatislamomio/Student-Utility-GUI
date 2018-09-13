import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class userUpdate {
    public static Stage updateStage = new Stage();
    public static void show()
    {
        try{
            //Stage updateStage = new Stage();
            FXMLLoader loader = new FXMLLoader(userUpdate.class.getResource("update.fxml"));

            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            updateStage.setScene(scene);
            updateStage.setTitle("Update");
            updateStage.getIcons().add(new Image(showProfile.class.getResourceAsStream("userMenu.png")));
            updateStage.setAlwaysOnTop(true);

            updateStage.show();


        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
