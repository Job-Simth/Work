package com.krokky.pro0421.tea;

public class InfuseMan {
    public int 沏茶(int ask, TeaMenu tm) {
        System.out.println("小张开始沏茶，顾客的选择是：" + tm.getTeas()[ask].getTeaName());
        System.out.println("......");
        return ask;
    }
}
