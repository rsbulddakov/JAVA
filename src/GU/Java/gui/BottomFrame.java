package GU.Java.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BottomFrame {
    private final JPanel panel;

    public BottomFrame(JTextField inputField) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3));

        DigitButtonListener buttonListener = new DigitButtonListener(inputField);
        for (int i = 0; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(buttonListener);
            panel.add(btn);
        }

        panel.add(new JButton("="));

        JButton clear = new JButton("C");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });
        panel.add(clear);

        panel.add(new JButton("+"));
        panel.add(new JButton("-"));
        panel.add(new JButton("SQRT"));
    }

    public JPanel getPanel() {
        return panel;
    }
}
