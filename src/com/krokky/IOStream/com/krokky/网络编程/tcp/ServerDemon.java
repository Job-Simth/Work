package com.krokky.IOStream.com.krokky.网络编程.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//Socket:TCP编程
public class ServerDemon {
    private Scanner pan = new Scanner(System.in);

    public static void main(String[] args) {
        new ServerDemon().b();
    }

    public void a() {
        try {
            //创建一个socket节点，服务端:ServerSocket创建
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("这个服务节点没有创建（没人占用）!");
            Socket s = ss.accept();//这是一个服务端节点
            System.out.println("这个节点创建了，有链接！");
            OutputStream out = s.getOutputStream();
            byte[] b = "Hello,Client!".getBytes();
            out.write(b);
            out.flush();
        } catch (IOException e) {
            System.out.println("出错了");
        }
    }

    public void b() {
        try {
            ServerSocket ss = new ServerSocket(8888);
            Socket s = ss.accept();
            OutputStream out = s.getOutputStream();
            String str;
            while (true) {
                System.out.println("请说：");
                str = pan.next();
                out.write(("服务端：" + str).getBytes());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
