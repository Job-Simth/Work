package com.krokky.Test;

import java.io.*;

public class CopyTxt {
    public static void main(String[] args) {
        FileWriter fw ;
        BufferedReader br ;

        try {
            fw = new FileWriter("e:\\test.txt");
            br = new BufferedReader(new InputStreamReader(new FileInputStream("e:\\b.txt"),"GBK"));
            String str;
            while ((str=br.readLine())!=null){
                fw.write(str+"\r\n");
                fw.flush();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
