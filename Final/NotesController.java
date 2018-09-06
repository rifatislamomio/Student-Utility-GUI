import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class NotesController {

    @FXML
    private DatePicker picker;

    @FXML
    private TextArea notes;

    @FXML
    void updateNotes(ActionEvent event) {
        data.put(picker.getValue(),notes.getText());


    }

    private Map<LocalDate,String> data= new HashMap<>();

    public void initialize(){
        load();
        picker.valueProperty().addListener((o,oldDate,date) ->{
            notes.setText(data.getOrDefault(date,""));

        });
        picker.setValue(LocalDate.now());
    }

    private void save()
    {
        try(ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(Paths.get("notes.data")))){
            stream.writeObject(data);
            System.out.println("Saved");
        }
        catch (Exception e)
        {
            System.out.println("FAILED");
        }

    }

    public void exit(ActionEvent event)
    {
        save();
        showNote.primaryStage.close();
    }

    private void load()
    {
        Path file = Paths.get("notes.data");
        if(Files.exists(file))
        {
            try(ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(file))){
                data = (Map<LocalDate,String>)stream.readObject();
                System.out.println("Loaded");
            }catch (Exception e)
            {
                System.out.println("Failed to load"+e);
            }
        }
    }




}
