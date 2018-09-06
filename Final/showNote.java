import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class showNote {
    public static Stage primaryStage = new Stage();

    public static void show()
    {
        try{
            FXMLLoader loader = new FXMLLoader((Main.class.getResource("Notes.fxml")));
            AnchorPane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Notes");
            primaryStage.getIcons().add(new Image("notes.png"));
            try {
                primaryStage.initStyle(StageStyle.UNDECORATED);
            }catch (Exception e)
            {

            }

            /* primaryStage.setOnCloseRequest(e4 -> {
                e4.consume();
                loader.<NotesController>getController().exit();
            });*/

            primaryStage.setAlwaysOnTop(true);
            primaryStage.show();

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
