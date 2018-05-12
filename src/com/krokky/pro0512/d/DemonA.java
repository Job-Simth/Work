package com.krokky.pro0512.d;

public class DemonA {
    private String name;
    private Integer age;

    public DemonA() {
        System.out.println("1");
    }

    public DemonA(String name) {

        this.name = name;
        System.out.println("2");
    }

    public DemonA(Integer age) {

        this.age = age;
        System.out.println("3");
    }

    public DemonA(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("4");
    }

    private DemonA(Double m) {
        System.out.println("5");
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", age=" + age;
    }
}
