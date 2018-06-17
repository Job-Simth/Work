package com.krokky.QQ.view;

import javax.swing.*;
import java.awt.*;

public class ServerView extends JFrame {
    private JTextArea main;
    private JTextField send;
    private JButton button;
    private JPanel panel;

    public ServerView() {
        setTitle("服务端界面");

        main = new JTextArea();
        send = new JTextField(24);
        button = new JButton("发送");
        panel = new JPanel();

        panel.add(send);
        panel.add(button);

        add(main, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 420, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
