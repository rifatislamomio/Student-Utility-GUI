import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CommonMethods {

    public static int mySerialGetter(String recieverUserName) throws Exception {

        int serial;
        System.out.println("recieverUserName:"+recieverUserName);
        ResultSet recieverRes = DataB.queryDb(DataB.con,"SELECT usernumber FROM users WHERE username = '"+recieverUserName+"'");
        recieverRes.next();
        int recieverUsernum = recieverRes.getInt("usernumber");

        if(showMessenger.usernumber>recieverUsernum)
            serial = 1;
        else
            serial = 2;

        return serial;
    }

    public static ArrayList<String> connectedPeopleLoader(){
        ArrayList<String> usernames = new ArrayList<>();
        try {
            DataInputStream input = new DataInputStream(new FileInputStream("AllFriends.dat"));
            try{
                while(true){
                    usernames.add(input.readUTF());
                }

            } catch (EOFException e){
                System.out.println("Loaded from AllFriends.dat to arraylist");

            } catch (IOException e) {
                e.printStackTrace();

            }

            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return usernames;
    }



    public static Boolean existsInFile(ArrayList<String> connectedPeople, String currentPerson){

        System.out.println("Current Person inside existsInFile:"+currentPerson);

        for (int i = 0; i < connectedPeople.size(); i++) {
            if (currentPerson.equals(connectedPeople.get(i)))
                return true;

        }

        return false;

    }
}
