import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class showMessenger {
    public static Stage primaryStage = new Stage();
    public static int usernumber;
    public static  String userName;

    public static void show(){

        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("StartPoint.fxml"));
            primaryStage.setTitle("Messenger");

            AnchorPane pane = loader.load();
            primaryStage.setScene(new Scene(pane));
            primaryStage.getIcons().add(new Image("globe.png"));
            primaryStage.setAlwaysOnTop(true);
            primaryStage.show();
            primaryStage.setOnCloseRequest(event -> {

                try {
                    showMenu.show();
                    DataB.con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });


        }catch (Exception e){}




    }
}
