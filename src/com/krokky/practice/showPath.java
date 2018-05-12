package com.krokky.practice;


import java.io.File;

//1：实现C盘下的树形结构
public class showPath {
    public static void main(String[] args) {
        File file = new File("D:\\");
        a(file, 0);
    }

    private static void a(File file, int k) {
        File[] f = file.listFiles();
        for (int i = 0; i < f.length; i++) {
            File ff = f[i];
            for (int j = 0; j < k; j++) {
                System.out.print("\t");
            }
            System.out.println(ff.getName());

            if (ff.isDirectory()) {
                a(ff, k++);
            }
        }
    }
}
