package com.krokky.DES.util;


import com.krokky.DES.ProcessingInput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import static com.krokky.DES.ProcessingInput.byteArr2HexStr;
import static com.krokky.DES.ProcessingInput.hexStr2ByteArr;

public class cipherPic {
    public static void EncriptPic(File file, String newPath, String keys) {
        try {
            FileOutputStream fos = new FileOutputStream(newPath);
            byte[] fileByte = Files.readAllBytes(file.toPath());
            String s = byteArr2HexStr(fileByte);

            int start = s.indexOf("003f00") + 6;
            int end = s.length() - 4;

            String head = s.substring(0, start);
            String str = s.substring(start, end);
            String tail = s.substring(end);

            String cipherText = ProcessingInput.runCipherEncrypt(str, keys);

            byte[] bytes = hexStr2ByteArr(head + cipherText + tail);

            fos.write(bytes);
            fos.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void DecriptPic(File file, String newPath, String keys) {
        try {
            FileOutputStream fos = new FileOutputStream(newPath);
            byte[] fileByte = Files.readAllBytes(file.toPath());
            String s = byteArr2HexStr(fileByte);

            int start = s.indexOf("003f00") + 6;
            int end = s.length() - 4;

            System.out.println(start + " " + end);

            String head = s.substring(0, start);
            String str = s.substring(start, end);
            String tail = s.substring(end);

            String cipherText = ProcessingInput.runCipherDecrypt(str, keys);

            byte[] bytes = hexStr2ByteArr(head + cipherText + tail);

            fos.write(bytes);
            fos.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}