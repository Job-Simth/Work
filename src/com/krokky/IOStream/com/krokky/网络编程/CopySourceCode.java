package com.krokky.IOStream.com.krokky.网络编程;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CopySourceCode {
    public static void main(String[] args) {
        try {
            //获取到路径
            URL url = new URL("https://stackoverflow.com/search?q=java");
            //打开路径，并将路径的链接获取到
            URLConnection urlConnection = url.openConnection();
            //向下转型成http的URLConnection
            HttpsURLConnection connection = (HttpsURLConnection) urlConnection;
            //负责产生一个字节的读取流
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            BufferedReader in = new BufferedReader(reader);
            String urlString = "";
            String current;
            while ((current = in.readLine()) != null) {
                urlString += current + "\n";
            }
            System.out.println(urlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
