package com.krokky.IOStream.com.krokky.网络编程;

import java.net.MalformedURLException;
import java.net.URL;

public class URLConn {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://stackoverflow.com/search?q=java");
            System.out.println("URL为:" + url.toString());
            System.out.println("协议为:" + url.getProtocol());
            System.out.println("验证信息为:" + url.getAuthority());
            System.out.println("文件名及请求参数为:" + url.getFile());
            System.out.println("主机名为:" + url.getHost());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}