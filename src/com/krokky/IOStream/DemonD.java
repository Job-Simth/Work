package com.krokky.IOStream;

import java.io.*;

public class DemonD {
    public static void main(String[] args) {
        try {
            File file = new File("E:\\d.txt");
            InputStream in = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(in);
            byte[] b = new byte[4];
            //size:实际大小，b声明大小
            int size = bis.read(b);
            System.out.println("实际大小" + size + "\t声明大小" + b.length);
            //按照byte数组生产一个字符串
            String str = new String(b);
            System.out.println(str.trim());
            bis.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
