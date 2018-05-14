package com.krokky.pro0512.reflectProgram;

public class A4TextPaper implements Paper {
    @Override
    public void print(String s) {
        char[] c = s.toCharArray();
        for (int i = 1; i < c.length + 1; i++) {
            System.out.print(c[i - 1]);
            if (i % 8 == 0) System.out.println(" ");
        }
    }
}
