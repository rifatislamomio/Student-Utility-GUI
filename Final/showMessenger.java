import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.SQLException;

public class showMessenger {
    public static Stage primaryStage = new Stage();
    public static int usernumber;
    public static  String userName;

    public static void show(){

        try{
            Parent root = FXMLLoader.load(Main.class.getResource("StartPoint.fxml"));
            primaryStage.setTitle("Chat Window");
            primaryStage.setScene(new Scene(root, 500 , 300));
            primaryStage.getIcons().add(new Image("globe.png"));
            primaryStage.setAlwaysOnTop(true);
            primaryStage.show();

            primaryStage.setOnCloseRequest(event -> {

                try {
                    DataB.con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });



        }catch (Exception e){}




    }
}
