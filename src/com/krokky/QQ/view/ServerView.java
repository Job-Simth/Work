package com.krokky.QQ.view;

import com.krokky.QQ.thread.Receive;
import com.krokky.QQ.thread.Send;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerView extends JFrame {
    private JTextArea main;
    private JTextField send;
    private JButton button;
    private JPanel panel;

    //网络通信内容
    private ServerSocket ss;
    private Socket s;

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

        button.addActionListener(new ButtonSend());

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 420, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        try {
            ss = new ServerSocket(8888);
            s = ss.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //被动接受数据
        try {
            Receive r = new Receive(s.getInputStream(), main);
            r.setDaemon(true);
            r.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ButtonSend implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            main.append("服务端" + send.getText() + "\n");
            try {
                new Send(s.getOutputStream(), "服务端:", send.getText()).start();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ServerView();
    }
}
