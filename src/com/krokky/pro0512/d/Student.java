package com.krokky.pro0512.d;

public class Student extends Person {

    private Double weight;
    public String className;

    public void study() {
        System.out.println(name + "正在学习");
    }

    private void eat(){
        System.out.println(name + "吃饭");
    }
}
