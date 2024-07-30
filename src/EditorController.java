import com.jfoenix.controls.JFXTextArea;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

public class EditorController {

    @FXML
    private JFXTextArea areaText;

    private TextFile currentTextFile;

    private EditorModel model;

    public EditorController(EditorModel model)
    {
        this.model = model;
    }

    public void close(ActionEvent e)
    {
        showEditor.primaryStage.close();
    }

    public void onLoad(ActionEvent e)
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showOpenDialog(null);
        if(file!=null)
        {
            IOResult<TextFile> io = model.load(file.toPath());

            if(io.isOk() &&io.hasData())
            {
                areaText.clear();
                currentTextFile = io.getData();
                currentTextFile.getContent().forEach(lines -> areaText.appendText(lines+"\n"));

            }
            else{
                Alert alert =new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error!");
                alert.setContentText("Failed to load!");
                alert.show();
            }
        }
    }


    public void onSave(ActionEvent e)
    {
        TextFile textFile = new TextFile(currentTextFile.getFile(), Arrays.asList(areaText.getText().split("\n")));
        model.save(textFile);
    }


    public void about()
    {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setContentText("Created by Rifat Islam!");
        alert.show();
    }

}
