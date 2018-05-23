package com.krokky.IOStream;

import java.io.*;

public class DemonA {
    Reader reader;
    BufferedReader br;

    public void a() {
        try {
            //第一步:要有两个节点
            File file = new File("F://a.txt");
            //第二步:建立java同file节点之间的连接通道，是一条单行线，只能从file到
            reader = new FileReader(file);
            //第三步:构建缓冲处理流,负责将内容运输到指定节点
            br = new BufferedReader(reader);
            //第四步:卸货操作，送到客户的手上了
            String str = br.readLine();
            //第五步:关闭流通道

            System.out.println(str);
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("ok");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void b() {
        try {
            File file = new File("C:\\Users\\Krokky\\Desktop\\常用类作业.txt");
            Reader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            String str;
            do {
                str = br.readLine();
                System.out.println(str == null ? "" : str);
            } while (str != null);
            br.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DemonA().b();
    }
}
