package com.krokky.网络编程.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientDemon {
    public static void main(String[] args) {
        new ClientDemon().b();
    }

    public void a() {
        try {
            Socket s = new Socket("localhost", 8888);
            //产生一个输入流
            InputStream in = s.getInputStream();
            byte[] b = new byte[1024];
            in.read(b);
            String str = new String(b);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void b() {
        try {
            Socket s = new Socket("127.0.0.1", 8888);
            InputStream in = s.getInputStream();
            while (true) {
                byte[] b = new byte[1024];
                in.read(b);
                String str = new String(b);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
