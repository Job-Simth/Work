package com.krokky.practice;

public class Student {
    public static final int AGE = 18;
    public static final String MAN = "男";
    public static final String WOMAN = "女";

    private String name;
    private int age;
    private String sex;

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "学生:" + name + " 年龄:" + age + " 性别:" + sex;
    }
}

