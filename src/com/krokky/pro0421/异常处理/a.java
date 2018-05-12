package com.krokky.pro0421.异常处理;

public class a {
    public static void main(String[] args) throws ArithmeticException {
        try {
            int i = 10 / 0;
            System.out.println(i);
        } catch (Exception e) {
            System.err.println(e);
//            a.main(args);
        }
    }
}
