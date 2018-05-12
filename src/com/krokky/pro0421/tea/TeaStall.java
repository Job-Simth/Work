package com.krokky.pro0421.tea;

import java.util.Scanner;

public class TeaStall {

    private TeaMenu tm = new TeaMenu();

    private Waitor waitor = new Waitor();

    private TeaClient client = new TeaClient();

    private InfuseMan man = new InfuseMan();

    private Scanner in = new Scanner(System.in);

    public void welcome() {
        System.out.println("有没有人来呀?");
        String ask = in.nextLine();
        if (ask.equalsIgnoreCase("y")) {
            waitor.询问(tm);
            int a = client.选择(in, tm);
            waitor.沟通(a, tm, man);

            System.out.println("过去了很长时间!!!");
            client.结账();
            double money = waitor.收钱(a, tm);
            double money2 = client.掏钱(in);

            waitor.找零(money, money2);

        } else {
            welcome();
        }
        ask = in.nextLine();//读取下一行的命令
        welcome();
    }

    public static void main(String[] args) {
        new TeaStall().welcome();
    }
}
