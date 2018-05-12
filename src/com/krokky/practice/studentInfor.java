package com.krokky.practice;

public class studentInfor {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(Student.AGE);
        stu.setSex(Student.MAN);

        System.err.println(stu.toString());
    }
}
