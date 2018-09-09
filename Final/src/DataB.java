import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataB {

    public static Connection con = ConnectionConfig.getConnection();



    public static void manipulateDb(Connection con, String sql){
        try {

            PreparedStatement manipulate = con.prepareStatement(sql);
            manipulate.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static ResultSet queryDb(Connection con,String sql){
        try{

            PreparedStatement query = con.prepareStatement(sql);
            ResultSet res = query.executeQuery();

            return res;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
