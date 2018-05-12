package com.krokky.pro0421.tea;

public class Waitor {

    public void 询问(TeaMenu tm) {
        System.out.println("你好,欢迎光临!");

        //展示茶单
        tm.show();
        System.out.println("请问,你需要什么?");
    }

    public void 沟通(int ask, TeaMenu tm, InfuseMan man) {
        System.out.println("小张,顾客选择了:" + tm.getTeas()[ask].getTeaName());
        System.out.println("快点沏好茶");
        int a = man.沏茶(ask, tm);
        端茶(a, tm);
    }

    public void 端茶(int ask, TeaMenu tm) {
        System.out.println("你好,这个是你的" + tm.getTeas()[ask].getTeaName());
        System.out.println("请慢用!");
    }

    public double 收钱(int ask, TeaMenu tm) {
        System.out.println("你好,你点了:" + tm.getTeas()[ask].getTeaName() + ",价格:" + tm.getTeas()[ask].getTeaPrice());
        return tm.getTeas()[ask].getTeaPrice();
    }

    public void 找零(double money, double money2) {
        if (money2 > money) {
            System.out.println("找你零钱:" + (money2 - money));
        }
        System.out.println("欢迎下次光临!");
    }
}
