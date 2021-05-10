package GU.Java.chat.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getInstance(){
        try{
            DriverManager.getConnection(
                    "jdbc:mysql://localhost:8888/users_db",
                    "root",
                    "root"
            );
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
