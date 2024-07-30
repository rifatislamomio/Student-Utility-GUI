import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private static int  serial;  ///user's serial in messaging database
    public static String chatWithPerson="";

    public static boolean threadState;
    
    Thread reciever = new Thread(){

        @Override
        public void run(){
            String recieve;

            Connection threadcon = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                 threadcon = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12254971", "sql12254971", "bxy39ghmAZ");
            } catch (SQLException e) {
                e.printStackTrace();
            }




            while (threadState) {

                try {
                    ResultSet recieveRes = DataB.queryDb(threadcon, "SELECT user" + (3 - serial) + "message FROM messages WHERE user" + serial + "= '" + showMessenger.userName + "' AND user" + (3 - serial) + " = '" + chatWithPerson + "'");
                    recieveRes.next();

                    if(recieveRes.getString("user"+(3-serial)+"message")!=null){
                        recieve = chatWithPerson+"-"+recieveRes.getString("user"+(3-serial)+"message")+"\n\n";

                        DataOutputStream output = new DataOutputStream(new FileOutputStream(chatWithPerson+".dat",true));
                        output.writeUTF(recieve);
                        output.close();  /**BUG????**/

                        conversation.appendText(recieve);

                        recieveRes.close();

                        DataB.manipulateDb(threadcon,"UPDATE messages SET user"+(3-serial)+"message = NULL WHERE user"+serial+"= '"+showMessenger.userName+"' AND user"+(3-serial)+"= '"+chatWithPerson+"'");
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                threadcon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    };



    @FXML
    public ListView<String> historyList = new ListView<>();
    @FXML
    Label chatMate;

    @FXML TextArea conversation;
    @FXML TextArea myMessage;
    @FXML Button sendButton ;
    @FXML Button message;
    @FXML Button reloadButton;


    @FXML Button report;
    @FXML RadioButton good;
    @FXML RadioButton bad;


    @FXML Button requestButton;

    public Controller() throws Exception {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadNecessaryData();
    }



    @FXML private void messageButtonClick() throws Exception {

        if(reciever.isAlive())
            threadState = false;

        chatWithPerson = historyList.getSelectionModel().getSelectedItem();


        /**REMOVE NEW MESSAGE ALERT**/
        if(historyList.getSelectionModel().getSelectedItem().charAt(0)== '!') {

            chatWithPerson = historyList.getSelectionModel().getSelectedItem().substring(1,historyList.getSelectionModel().getSelectedItem().length()-1);
            //Get the Proper username(without !)

            historyList.getItems().remove(historyList.getSelectionModel().getSelectedIndex());
        }
        /***/

        serial = CommonMethods.mySerialGetter(chatWithPerson);


        /**ADD PREVIOUS CONVERSATION FROM FILE**/
        DataInputStream input = new DataInputStream(new FileInputStream(chatWithPerson+".dat"));
        try {

            while(true)
                conversation.appendText(input.readUTF());

        }catch (EOFException e){
            input.close();
            System.out.println("previous chats loaded");
        }catch (Exception e){
            e.printStackTrace();
        }

        report.setDisable(false);
        myMessage.setDisable(false);
        myMessage.setText("");
        myMessage.setPromptText("Write Your Message...");
        chatMate.setText(historyList.getSelectionModel().getSelectedItem());


        /**START THE RECIEVING THREAD**/
        threadState=true;
        reciever.start();


    }




    @FXML private void sendButtonClick() throws Exception {


        if (chatMate.getText().equals("Select From History") == false) {

            DataOutputStream output = new DataOutputStream(new FileOutputStream(chatWithPerson+".dat",true));

            String sent = "You-" + myMessage.getText() + "\n\n";

            output.writeUTF(sent);
            output.close();


            ResultSet nullCheckRes = DataB.queryDb(DataB.con,"SELECT user"+serial+"message FROM messages WHERE user"+serial+" = '"+showMessenger.userName+"' AND user"+(3-serial)+"= '"+chatWithPerson+"'");
            nullCheckRes.next();

            if(nullCheckRes.getString("user"+serial+"message")!=null)
                DataB.manipulateDb(DataB.con,"UPDATE messages SET user"+serial+"message = CONCAT(user"+serial+"message,'"+myMessage.getText()+"') WHERE user"+serial+" = '"+showMessenger.userName+"' AND user"+(3-serial)+" = '"+chatWithPerson+"'");
            else
                DataB.manipulateDb(DataB.con,"UPDATE messages SET user"+serial+"message = '"+myMessage.getText()+"' WHERE user"+serial+" = '"+showMessenger.userName+"' AND user"+(3-serial)+" = '"+chatWithPerson+"'");


             conversation.appendText(sent);
             myMessage.setText("");
             myMessage.setPromptText("Write Your Message...");
        }

        else {
            myMessage.setText("No one selected");
            myMessage.setDisable(true);
        }

    }


    @FXML public void reportButtonClicked() throws IOException {
        Stage reviewPopUp = new Stage();
          Parent reviewParent = FXMLLoader.load(getClass().getResource("Report-POPUP.fxml"));
          reviewPopUp.setTitle("REVIEW");
          reviewPopUp.setScene(new Scene(reviewParent, 300, 100));
          try{
          reviewPopUp.initModality(Modality.APPLICATION_MODAL);}catch (Exception e){}
          reviewPopUp.show();


    }

    @FXML private void requestButtonClick() throws IOException{

        Stage requestWindow = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowRequests.fxml"));
        AnchorPane pane = loader.load();
        requestWindow.setTitle("REQUESTS");
        requestWindow.setScene(new Scene(pane));

        requestWindow.setAlwaysOnTop(true);

        requestWindow.getIcons().add(new Image("Messenger-icon.png"));

        requestWindow.initModality(Modality.APPLICATION_MODAL);

        requestWindow.show();
    }


    @FXML private void reloadButtonClicked(){
        historyList.getItems().clear();
        loadNecessaryData();
    }


    @FXML private void historyListSelected(){
        message.setDisable(false);
    }

    public void loadNecessaryData(){

        message.setDisable(true);


        try {

            /**LOAD NEW MESSAGES
             * ADD TO HISTORYLIST : "!username!"**/

            ResultSet newMessageRes = DataB.queryDb(DataB.con, "SELECT * FROM messages WHERE user1 = '" + showMessenger.userName + "' OR user2= '" + showMessenger.userName + "'");
            while (newMessageRes.next()) {

                if (newMessageRes.getString("user1").equals(showMessenger.userName)) {

                    if (newMessageRes.getString("user2message") != null) {
                        if (CommonMethods.existsInFile(CommonMethods.connectedPeopleLoader(), newMessageRes.getString("user2")))
                            historyList.getItems().add("!" + newMessageRes.getString("user2") + "!");
                    }
                }

                else {

                    if (newMessageRes.getString("user1message") != null) {
                        if (CommonMethods.existsInFile(CommonMethods.connectedPeopleLoader(), newMessageRes.getString("user1")))
                            historyList.getItems().add("!" + newMessageRes.getString("user1") + "!");
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        /**ADD HISTORYLIST FROM FILE**/
        DataInputStream input = null;

        try{
            input = new DataInputStream(new FileInputStream("AllFriends.dat"));
            while(true){
                historyList.getItems().add(input.readUTF());
            }

        }catch(EOFException e){
            try {
                input.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println("Read All From File");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public  void closeByX(){

        threadState = false;
    }
}
