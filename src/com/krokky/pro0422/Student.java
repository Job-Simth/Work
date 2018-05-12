package com.krokky.pro0422;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private Integer stuNo;
    private String stuName;
    private Integer stuAge;
    private String stuSex;

    public void a() {
        List<Student> stu = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student(i);
            stu.add(student);
        }

        //自动拆箱,自动装箱
//        for (Student s : stu) {
//            if (s.getStuSex().equals("男")) {
//                s.setStuAge(999);
//            }
//        }

//        stu.contains("")
//        for (Student s : stu) {
//            System.out.println(s);
//        }
    }

    public void b() {
        List<Student> stu = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student(i);
            stu.add(student);
        }
        System.out.println("原始内容：");
        for (Student s : stu) {
            System.out.println(s);
        }
        Collections.sort(stu);
        System.out.println("排序后的内容");
        for (Student s : stu) {
            System.out.println(s);
        }
    }

    public void c(){
        List<String> list = new ArrayList<>();
        list.add("陕西");
        list.add("山西");
        list.add("湖北");
        list.add("湖南");

        String str = new String("湖北");


        boolean b = list.contains(str);
        int index = list.indexOf(str);
        System.out.println(b+"\t"+index);
    }

    public Student(int i) {
        stuNo = i + 1;
        int k = (int) (Math.random() * 2 + 2);
        stuName = "";
        for (int j = 0; j < k; j++) {
            char c = (char) ((int) (Math.random() * 1000 + 20000));
            stuName += c;
        }
        stuAge = (int) (Math.random() * 10 + 18);
        stuSex = (k % 2 == 0) ? "男" : "女";
    }

    public Student() {

    }

    public Integer getStuNo() {

        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo= " + stuNo + "\t" +
                "stuName= " + stuName + "\t" +
                "stuAge=" + stuAge + "\t" +
                "stuSex= " + stuSex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(stuNo, student.stuNo);
    }

    @Override
    public int compareTo(Student o) {
        int result = this.getStuAge() - o.getStuAge();
        int no = this.getStuNo() - o.getStuNo();

        if (result == 0)
            return no;

        return result;
    }

    public static void main(String[] args) {
        new Student().c();
    }

}