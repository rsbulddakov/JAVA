package GU.Java;

import GU.Java.chat.logger.logs.Logger;
import GU.Java.chat.server.DBConnection;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String s = Logger.readLastLines("history_all.txt", 10);
        System.out.println(s);
    }
}
