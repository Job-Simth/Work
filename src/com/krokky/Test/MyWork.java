package com.krokky.Test;

import java.io.*;

public class MyWork {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("e:\\b.txt"),"GBK"));
            FileWriter fw = new FileWriter("e:\\test1.txt");
            String str ;
            while ((str=br.readLine())!=null){
                fw.write(str+"\r\n");
                fw.flush();
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
