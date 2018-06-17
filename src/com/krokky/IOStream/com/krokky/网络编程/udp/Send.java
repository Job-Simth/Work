package com.krokky.IOStream.com.krokky.网络编程.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {
    public static void main(String[] args) {
        try {
            //创建一个UDP的套接字
            DatagramSocket socket = new DatagramSocket();
            //创建一个负责发送的数据报,需要四个参数：内容，长度，接收方ip，接收方端口
            byte[] buf = "Hello,UDP!".getBytes();
            int length = buf.length;
            InetAddress address = InetAddress.getLocalHost();
            int port = 9999;
            DatagramPacket packet = new DatagramPacket(buf, length, address, port);
            //发送
            socket.send(packet);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
