package com.krokky.pro0422;

public class ClassInfo implements Comparable<ClassInfo> {
    int classId;
    String ClassName;
    int classNum;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public ClassInfo(int classId, String className, int classNum) {

        this.classId = classId;
        ClassName = className;
        this.classNum = classNum;
    }

    @Override
    public int compareTo(ClassInfo o) {
        return this.classNum - o.classNum;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "classId=" + classId +
                ", ClassName='" + ClassName + '\'' +
                ", classNum=" + classNum +
                '}';
    }
}
