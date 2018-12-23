package com.krokky.DES;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class ProcessingInput {

    public static void main(String[] args) {

//        String s = "1234ascedesx";
        String s = "7602f7413496a5611ab3bd61806ceca1";
        String keys = "11111111";

        long key = getKey(keys);
//        runCipherEncrypt(s, key);
        runCipherDecrypt(s, key);


    }

    /**
     * 将输入的比特数组每8位组合在一起，压缩成64位的数组
     *
     * @param input
     * @return
     */
    private static long[] splitInputIntoBlocks(byte[] input) {
        int size;
        if (input.length % 8 == 0) {
            size = input.length / 8;
        } else {
            size = input.length / 8 + 1;
        }

        long blocks[] = new long[size];

        for (int i = 0, j = -1; i < input.length; i++) {
            if (i % 8 == 0) {
                j++;
            }
            blocks[j] <<= 8;
            if (input[i] < 0) {
                blocks[j] |= input[i] + 256;
            } else {
                blocks[j] |= input[i];
            }

        }
        return blocks;
    }

    public static String runCipherEncrypt(String s, long key) {
        byte[] text = s.getBytes();
        long[] blocks = splitInputIntoBlocks(text);

        DES des = new DES();
        byte[] bytes;
        long[] cipherTexts = new long[blocks.length];
        ArrayList<Byte> sl = new ArrayList<>();

        for (int i = 0; i < blocks.length; i++) {
            cipherTexts[i] = des.encrypt(blocks[i], key);
        }

        for (long block : cipherTexts) {
            bytes = ByteBuffer.allocate(8).putLong(block).array();
            for (byte b : bytes) {
                sl.add(b);
            }
        }

        byte[] a = new byte[sl.size()];
        for (int i = 0; i < sl.size(); i++) {
            a[i] = sl.get(i);
        }
        return byteArr2HexStr(a);

    }

    public static String runCipherDecrypt(String s, long key) {
        byte[] text = hexStr2ByteArr(s);
        long[] blocks = splitInputIntoBlocks(text);

        DES des = new DES();
        byte[] bytes;
        long[] plainTexts = new long[blocks.length];
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < blocks.length; i++) {
            plainTexts[i] = des.decrypt(blocks[i], key);
        }
        for (long block : plainTexts) {
            bytes = ByteBuffer.allocate(8).putLong(block).array();
            System.out.print(new String(bytes));
            sb.append(new String(bytes));
        }
        return sb.toString();
    }

    /**
     * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813，和
     * public static byte[] hexStr2ByteArr(String strIn) 互为可逆的转换过程
     *
     * @param arrB 需要转换的byte数组
     * @return 转换后的字符串
     */
    public static String byteArr2HexStr(byte[] arrB) {

        int iLen = arrB.length;
        // 每个byte用2个字符才能表示，所以字符串的长度是数组长度的2倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * 将表示16进制值的字符串转换为byte数组，和public static String byteArr2HexStr(byte[] arrB)
     * <p>
     * 互为可逆的转换过程
     *
     * @param strIn 需要转换的字符串
     * @return 转换后的byte数组
     */
    public static byte[] hexStr2ByteArr(String strIn) {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    public static long getKey(String keys) {
        byte[] keyBytes;
        long key64 = 0;
        keyBytes = keys.getBytes();

        for (byte keyByte : keyBytes) {
            key64 <<= 8;
            key64 |= keyByte;
        }
        return key64;
    }
}
