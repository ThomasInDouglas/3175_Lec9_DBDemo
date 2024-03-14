package com.example.a3175_lec9_dbdemo.models;

public class Student {
    private String StudId;
    private String StudName;
    private String StuDept;

    public Student(String studId, String studName, String stuDept) {
        StudId = studId;
        StudName = studName;
        StuDept = stuDept;
    }

    public String getStudId() {
        return StudId;
    }

    public void setStudId(String studId) {
        StudId = studId;
    }

    public String getStudName() {
        return StudName;
    }

    public void setStudName(String studName) {
        StudName = studName;
    }

    public String getStuDept() {
        return StuDept;
    }

    public void setStuDept(String stuDept) {
        StuDept = stuDept;
    }
}
