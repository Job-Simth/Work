package com.krokky.practice;

public class father {
    public String name = "张三";
    private String 民族 = "汉";

    public father(String name) {
        this.name = name;
        System.out.println("父类被创建了");
    }

    public father() {

    }

    @Override
    public String toString() {
        return "我是" + name + "\n民族:" + 民族;
    }
}
