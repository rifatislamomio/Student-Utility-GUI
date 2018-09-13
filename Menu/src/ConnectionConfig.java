import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {
    public static Connection getConnection()
    {
        Connection connection = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12253963","sql12253963","UYLkv77fze");

        } catch(Exception e)
        {
            System.out.println(e);;
        }

        return connection;



    }

}
