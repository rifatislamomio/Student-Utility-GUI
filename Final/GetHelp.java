import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.sql.ResultSet;


public class GetHelp {
    @FXML
    ListView<String> searchedList = new ListView<>();
    @FXML
    TextField searchTextField;
    @FXML
    Button goButton;
    @FXML Button selectButton;

    @FXML
    Label helpLabel;

    public static String selectedPerson;

    @FXML private void goButtonClick() throws Exception {

        searchedList.getItems().clear();

        /** Search FORMAT:
         * name, department,username
         **/

        ResultSet searchedinfos;
        String name,department,usename;
        String searchString = searchTextField.getText();

        int commaCount=0;
        for(int i=0;i<searchString.length();i++){
            if(searchString.charAt(i)==',')
                commaCount++;
        }
        if(commaCount==2){
            int i,departmentInitialIndex;

            //Use String.indexOf()
            for(i=0;searchString.charAt(i)!=',';i++);
            for(departmentInitialIndex=i+1;searchString.charAt(departmentInitialIndex)!=',';departmentInitialIndex++);

            name = searchString.substring(0,i);  //FIRST PORTION OF searchString BEFORE COMMA
            department = searchString.substring(i+1,departmentInitialIndex);   //SECOND PORTION OF searchString BEFORE COMMA

            if(departmentInitialIndex-i!=4)
                helpLabel.setText("Invalid Department Initial Or Must Add Dept.");

            else{
                int userNameIndex;
                for(userNameIndex=departmentInitialIndex+1;userNameIndex<searchString.length();userNameIndex++);

                if(userNameIndex-departmentInitialIndex<=6&&userNameIndex-departmentInitialIndex!=1)
                    helpLabel.setText("Invalid Usename");

                else if(userNameIndex-departmentInitialIndex==1){
                    if(i<2)
                        helpLabel.setText("Invalid Name or Must add Name with Dept.");

                    else{

                        //Search Database With Name and Dept.
                        searchedinfos = DataB.queryDb(DataB.con,"SELECT * FROM users WHERE (firstname = '"+name+"' OR lastname = '"+name+"') AND department = '"+department.toUpperCase()+"'");

                        while (searchedinfos.next()){

                            String currentPerson = searchedinfos.getString("username");

                            if( !CommonMethods.existsInFile( CommonMethods.connectedPeopleLoader() , currentPerson) )    /**SHOW ONLY PEOPLE NOT CONNECTED WITH ALREADY**/
                                 searchedList.getItems().add(searchedinfos.getString("firstname")+" "+searchedinfos.getString("lastname")+"("+currentPerson+")");

                        }
                        searchedinfos.close();

                        if(!searchedList.getSelectionModel().isEmpty())
                            helpLabel.setText("!INVALID ENTRY!");
                        else
                            helpLabel.setText("Search Successful!");
                    }

                }

                else if(userNameIndex-departmentInitialIndex!=0){
                    //Search Database with just username
                    usename = searchString.substring(departmentInitialIndex+1,searchString.length());

                    searchedinfos = DataB.queryDb(DataB.con,"SELECT * FROM users WHERE username = '"+usename+"'");

                    while (searchedinfos.next()){

                        String currentPerson = searchedinfos.getString("username");

                        if( !CommonMethods.existsInFile( CommonMethods.connectedPeopleLoader() , currentPerson) )  /**SHOW ONLY PEOPLE NOT CONNECTED WITH ALREADY**/
                            searchedList.getItems().add(searchedinfos.getString("firstname")+" "+searchedinfos.getString("lastname")+"("+currentPerson+")");

                    }
                    searchedinfos.close();

                    if(!searchedList.getSelectionModel().isEmpty())
                        helpLabel.setText("!INVALID ENTRY!");
                    else
                        helpLabel.setText("Search Successful!");
                }

            }
        }

        else
            helpLabel.setText("Provide BLANK SPACE between commas(Must add 2 commas)!");

    }


    @FXML private void searchListSelected(){
       selectButton.setDisable(false);
    }


    @FXML private void selectButtonClick() throws IOException {
        selectedPerson = searchedList.getSelectionModel().getSelectedItem().substring(searchedList.getSelectionModel().getSelectedItem().indexOf('(')+1,searchedList.getSelectionModel().getSelectedItem().length()-1);

        selectButton.setDisable(true);
        
        Stage sendMessage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("getHelpSendMessage.fxml"));
        sendMessage.setTitle("Send New Message");
        sendMessage.setScene(new Scene(root, 565 , 493));

        sendMessage.setAlwaysOnTop(true);
        try {
            sendMessage.initModality(Modality.APPLICATION_MODAL);
        }catch (Exception e){}

        sendMessage.getIcons().add(new Image("/search.png"));

        sendMessage.show();
        ///Load Selected user profile
    }

}
