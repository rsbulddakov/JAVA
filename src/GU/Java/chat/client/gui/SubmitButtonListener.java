package GU.Java.chat.client.gui;

import GU.Java.chat.client.gui.api.Sender;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitButtonListener implements ActionListener {
    private final JTextField inputField;
    private final Sender sender;

    public SubmitButtonListener(JTextField inputField, Sender sender) {
        this.inputField = inputField;
        this.sender = sender;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sender.send(inputField.getText());
        inputField.setText("");
    }
}
