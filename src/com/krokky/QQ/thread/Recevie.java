package com.krokky.QQ.thread;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

public class Recevie extends Thread {
    private InputStream in;
    private JTextArea jta;

    public Recevie(InputStream in, JTextArea jta) {
        this.in = in;
        this.jta = jta;
    }

    @Override
    public void run() {
        byte[] b = new byte[1024];
        try {
            in.read(b);
            String str = new String(b);
            jta.append(str + "\n");//将接收到的东西接收到文本域
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
