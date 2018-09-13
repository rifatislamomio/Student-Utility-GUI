import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class showEditor {
    public static Stage primaryStage;
    public static void start() throws Exception{

        FXMLLoader loader = new FXMLLoader(showEditor.class.getResource("editor.fxml"));
        loader.setControllerFactory(t -> new EditorController(new EditorModel()));
        BorderPane pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
