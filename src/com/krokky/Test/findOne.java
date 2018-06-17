package com.krokky.Test;

import java.util.Scanner;

public class findOne {
    private int count = 0;//全局变量，统计1的个数，java的全局变量不能在方法里修改，使用的只是引用

    public static void main(String[] args) {
        int i;
        Scanner s = new Scanner(System.in);
        i = s.nextInt();
        System.out.println((new findOne().find(i)));
    }

    /**
     * 通过短除法来判断有多少个1
     *
     * @param i
     * @return
     */
    public int find(int i) {
        if (i == 0)//除尽了就返回
            return 0;
        if (i % 2 == 1) {//没除尽就判断取余2是否为1，为1就使count自增
            count++;
        }
        find(i / 2);//递归，每次除以2
        return count;
    }
}
