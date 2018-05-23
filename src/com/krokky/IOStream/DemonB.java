package com.krokky.IOStream;

import java.io.*;
import java.util.Scanner;

public class DemonB {
    public void a() {
        try {
            //第一步:要有两个节点
            File file = new File("E:\\b.txt");
            //如果不存在，就创建这个文件
            boolean b = file.exists();
            if (!b) {
                file.createNewFile();
            }
            //第二步:创建写入流节点对象
            Writer out = new FileWriter(file);
            //第三步:创建缓冲流来提升写入操作
            BufferedWriter bw = new BufferedWriter(out);
            bw.write("Hello,world");//写入
            //第四步:关闭
            bw.flush();//刷新
            bw.close();//关闭自带刷新，但关闭一般在最后
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Scanner s = new Scanner(System.in);

    public void b() {
        try {
            File file = new File("E:\\b.txt");
            //第二个参数为操作模式，true是追加，false是覆盖(默认)
            Writer out = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(out);
            System.out.print("请输入:");
            String str = s.nextLine();
            while (!"exit".equals(str)) {
                bw.write(str + "\r\n");
                System.out.print("请输入:");
                str = s.nextLine();
                bw.flush();
            }
            bw.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void c() {
        try {
            File file = new File("E://a.xls");
            Writer out = new FileWriter(file, true);//true表示追加
            BufferedWriter bw = new BufferedWriter(out);
            String str = "编号\t姓名\t年龄\n";
            bw.write(str);
            bw.flush();
            for (int i = 1; i < 11; i++) {
                str = i + "\t" + (char) ((int) (Math.random() * 26 + 97)) + "\t" + (int) (Math.random() * 60 + 10) + "\n";
                bw.write(str);
                bw.flush();
            }
            bw.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void d() {
        try {
            File file = new File("E://c.txt");
            Writer out = new FileWriter(file);
            out.write("aaaaaa");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DemonB().d();
    }
}
