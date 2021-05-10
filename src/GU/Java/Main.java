package GU.Java;

import GU.Java.chat.server.DBConnection;
import java.sql.Connection;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Connection connection = DBConnection.getInstance();
        System.out.println("connection = " + connection);
    }
}
