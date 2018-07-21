package com.krokky.网络编程.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9999);
            byte[] buf = new byte[100];//缓冲区定义一次最多能接受的大小
            int length = buf.length;
            DatagramPacket packet = new DatagramPacket(buf, length);
            socket.receive(packet);

            byte[] rece = packet.getData();
            String str = new String(rece);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
