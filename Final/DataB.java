import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataB {

    public static Connection con;

    public static Connection getDbConnection(){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12254971", "sql12254971", "bxy39ghmAZ");
            return con;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

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
