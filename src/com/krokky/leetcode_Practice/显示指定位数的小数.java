package com.krokky.leetcode_Practice;

//截取小数点后两位，使用String的截取
public class 显示指定位数的小数 {
    public static void main(String[] args) {
        String s = String.valueOf(Math.random() * 100 + 30);//生成小于100的随机数并转成String
        if (s.contains(".")) {//是否包含'.'
            int end = s.indexOf(".");//'.'的位置，本例为2（ab.cdefgh）
            s = s.substring(0, end + 3);
        }
        System.out.println(s);
    }
}
