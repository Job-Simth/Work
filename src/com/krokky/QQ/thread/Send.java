package com.krokky.QQ.thread;

import java.io.IOException;
import java.io.OutputStream;

public class Send extends Thread {
    private OutputStream out;
    private String name;
    private String content;

    public Send(OutputStream out, String name, String content) {
        this.out = out;
        this.name = name;
        this.content = content;
    }

    @Override
    public void run() {
        byte[] b = (name + ":" + content).getBytes();
        try {
            out.write(b);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}