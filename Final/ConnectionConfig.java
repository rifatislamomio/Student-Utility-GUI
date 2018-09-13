import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {
    public static Connection getConnection()
    {
        Connection connection = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12254971", "sql12254971", "bxy39ghmAZ");

        } catch(Exception e)
        {
            System.out.println(e);;
        }

        return connection;



    }

}
