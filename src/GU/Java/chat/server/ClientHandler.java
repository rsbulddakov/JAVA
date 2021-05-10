package GU.Java.chat.server;

import GU.Java.chat.logger.logs.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ChatServer chatServer;
    private String name;
    private String login;
    private int secondsForAuth = 120;
    private boolean isLogined = false;

    public ClientHandler(Socket socket, ChatServer chatServer) {
        this.socket = socket;
        this.chatServer = chatServer;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during client establishing.", e);
        }

        new Thread(() -> {
            doAuthentication();
            listen();
        })
                .start();
    }

    public String getName() {
        return name;
    }
    public String getLogin() {
        return login;
    }

    private void listen() {
        receiveMessage();
    }

    private void doAuthentication() {
        authTimer();
        sendMessage("Welcome! Please do authentication.");
        while (true) {
            try {
                /**
                 * login pattern
                 * -auth l1 p1
                 */
                String message = in.readUTF();

                if (message.startsWith("-auth")) {
                    String[] credentialsStruct = message.split("\\s");
                    String login = credentialsStruct[1];
                    String password = credentialsStruct[2];

                    Optional<User> mayBeCredentials = Optional.ofNullable(chatServer.getAuthenticationService()
                            .findEntryByCredentials(login, password));

                    if (mayBeCredentials.isPresent()) {
                        User credentials = mayBeCredentials.get();
                        if (!chatServer.isLoggedIn(credentials.getLogin())) {
                            isLogined = true;
                            name = credentials.getName();
                            this.login = credentials.getLogin();
                            chatServer.broadcast(String.format("User[%s] entered the chat", name));
                            chatServer.subscribe(this);
                            sendMessage(Logger.readLastLines("history_all.txt", 100));
                            return;
                        } else {
                            sendMessage(String.format("User with name %s is already logged in", credentials.getName()));
                        }
                    } else {
                        sendMessage("Incorrect login or password.");
                    }
                } else {
                    sendMessage("Incorrect authentication message. " +
                            "Please use valid command: -auth your_login your_pass");
                }
            } catch (IOException e) {
                throw new ChatServerException("Something went wrong during client authentication.", e);
            }
        }
    }

    public void receiveMessage() {
        while (true) {
            try {
                String message = in.readUTF();
                String formatted_message = String.format("%s: %s", name, message);
                chatServer.broadcast(formatted_message);
                Logger.addLine("history_" + login + ".txt", formatted_message);
                Logger.addLine("history_all.txt", formatted_message);
            } catch (IOException e) {
                throw new ChatServerException("Something went wrong during receiving the message.", e);
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during sending the message.", e);
        }
    }

    private void authTimer(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(!isLogined) {
                    sendMessage("Time for authentication is over. Disconnect");
                    closeConnection();
                }
            }
        }, secondsForAuth*1000);
    }

    private void closeConnection(){
        try {
            socket.close();
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during closing socket.", e);
        }
    }
}
