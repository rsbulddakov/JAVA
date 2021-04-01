package GU.Java.communication.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.text.*;

public class Server {
    private static SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm:ss '| client: '");
    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is ready...");
            System.out.println("Waiting for a connection...");
            Socket accept = serverSocket.accept();
            System.out.println("Connection established: " + accept);

            DataInputStream in = new DataInputStream(accept.getInputStream());
            DataOutputStream out = new DataOutputStream(accept.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            new Thread(() -> {
                while (true) {
                    try {
                        out.writeUTF(scanner.nextLine());
                    } catch (IOException e) {
                        System.out.println("Client disconnected...");
                        System.out.println("Connection closed.");
                        break;
                    }
                }
            })
                    .start();

            while (true) {
                try {
                    String message = in.readUTF();
                    Date dateNow = new Date();
                    System.out.println(formatForDateNow.format(dateNow) + message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
