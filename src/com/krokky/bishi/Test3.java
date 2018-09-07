package com.krokky.bishi;

public class Test3 {
    public static void main(String[] args) {
        String str1 = "welcome";
        String str2 = str1.concat("welcome");
        String substring = str2.substring(3, 5);
        System.out.println(substring.startsWith("c"));
    }
}
