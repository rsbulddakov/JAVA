package GU.Java.chat.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getInstance(){
        try{
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/users_db?autoReconnect=true&useSSL=false",
                    "root",
                    "root"
            );
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
