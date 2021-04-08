package GU.Java.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

                    Optional<AuthenticationService.Entry> mayBeCredentials = chatServer.getAuthenticationService()
                            .findEntryByCredentials(login, password);

                    if (mayBeCredentials.isPresent()) {
                        AuthenticationService.Entry credentials = mayBeCredentials.get();
                        if (!chatServer.isLoggedIn(credentials.getName())) {
                            isLogined = true;
                            name = credentials.getName();
                            chatServer.broadcast(String.format("User[%s] entered the chat", name));
                            chatServer.subscribe(this);
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
                chatServer.broadcast(String.format("%s: %s", name, message));
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
