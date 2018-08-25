package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {
    public static Connection getConnection()
    {
        Connection connection = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12252919","sql12252919","CaB9mHENr1");

        } catch(Exception e)
        {
            System.out.println(e);;
        }

        return connection;



    }

}
