package com.krokky.pro0421.tea;

import java.util.Scanner;

public class TeaClient {

    public int 选择(Scanner in, TeaMenu tm) {

        int ask = in.nextInt();

        System.out.println("你好,我选择" + tm.getTeas()[ask - 1].getTeaName());

        return ask - 1;
    }

    public void 结账() {
        System.out.println("服务员,买单!");
    }

    public double 掏钱(Scanner in) {
        double money = in.nextDouble();
        System.out.println("这个是:" + money);
        return money;
    }

}
