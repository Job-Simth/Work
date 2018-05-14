package com.krokky.pro0512.d;

public class Demon {
    private String name;
    private Integer age;

    public Demon() {
        System.out.println("1");
    }

    public Demon(String name) {

        this.name = name;
        System.out.println("2");
    }

    public Demon(Integer age) {

        this.age = age;
        System.out.println("3");
    }

    public Demon(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("4");
    }

    private Demon(Double m) {
        System.out.println("5");
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", age=" + age;
    }
}
