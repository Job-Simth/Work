package com.pro0506;

import java.io.*;

public class DemonE {
    public static void main(String[] args) {
        String str = "abcdefg";
        byte[] b = str.getBytes();

        try {
            File file = new File("E://d.txt");
            OutputStream out = new FileOutputStream(file);

            BufferedOutputStream bos = new BufferedOutputStream(out);
            //b:写的内容,off:从第几开始,len:写几个字节
            bos.write(b, 0, str.length()*2);
            bos.flush();
            bos.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
