import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowRequests implements Initializable {

    @FXML Button showMessageButton;
    @FXML ListView<String> nameList = new ListView<>();
    @FXML Label addList;
    @FXML TextArea conversation;
    @FXML Button addButton;
    @FXML Button deleteButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> connectedPeople = CommonMethods.connectedPeopleLoader();   //Loads from FILE Already connected peoples username


        try {
            ResultSet peopleToShowRes = DataB.queryDb(DataB.con, "SELECT * FROM messages WHERE user1 ='" + showMessenger.userName + "' OR user2= '" + showMessenger.userName + "'");

            if (peopleToShowRes != null) {
                while (peopleToShowRes.next()) {
                    String currentPerson;

                    if (peopleToShowRes.getString("user1").equals(showMessenger.userName))
                        currentPerson = peopleToShowRes.getString("user2");
                    else
                        currentPerson = peopleToShowRes.getString("user1");

                    if( !CommonMethods.existsInFile(connectedPeople , currentPerson))  //If current person al;ready exists in FILE or not
                        nameList.getItems().add(currentPerson);

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML private void showMessageClick() throws Exception {

        addButton.setDisable(false);
        deleteButton.setDisable(false);

        addList.setText(nameList.getSelectionModel().getSelectedItem());
        conversation.setDisable(false);

        int serial = CommonMethods.mySerialGetter(nameList.getSelectionModel().getSelectedItem());
        ResultSet recievedMessageRes = DataB.queryDb(DataB.con , "SELECT user" + (3 - serial) + "message FROM messages WHERE user" + serial + "= '" + showMessenger.userName + "' AND user" + (3 - serial) + " = '" + nameList.getSelectionModel().getSelectedItem() + "'");
        System.out.println("user"+(3-serial)+"message");
        recievedMessageRes.next();

        conversation.setText(recievedMessageRes.getString("user"+(3-serial)+"message"));
    }

    @FXML private void addClick() throws IOException {
       //Add to chat history file
        DataOutputStream output = new DataOutputStream(new FileOutputStream("AllFriends.dat",true));
        System.out.println(addList.getText());
        output.writeUTF(addList.getText());
        output.close();

        output = new DataOutputStream(new FileOutputStream(addList.getText()+".dat"));
        output.writeUTF(conversation.getText());
        output.close();

        addButton.setDisable(true);
        deleteButton.setDisable(true);
    }

    @FXML private void deleteClick() {
        nameList.getItems().remove(nameList.getSelectionModel().getSelectedIndex());

        DataB.manipulateDb(DataB.con,"DELETE FROM messages WHERE (user1 = '"+addList.getText()+"' AND user2= '"+showMessenger.userName+"') OR (user1 = '"+showMessenger.userName+"' AND user2 = '"+addList.getText()+"'");

        addButton.setDisable(true);
        deleteButton.setDisable(true);
    }


    @FXML private void nameListSelected(){
        addButton.setDisable(true);
        deleteButton.setDisable(true);
    }

}
