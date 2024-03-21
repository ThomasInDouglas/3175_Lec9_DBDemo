package com.example.a3175_lec9_dbdemo.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "students")
public class Student {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "studentid") //name of the column in the database
    private String StudId;

    @ColumnInfo(name = "studentname")
    private String StudName;

    @ColumnInfo(name = "studentdept")
    private String StuDept;

    public Student() {
    }

    public Student(@NonNull String studId, String studName, String stuDept) {
        StudId = studId;
        StudName = studName;
        StuDept = stuDept;
    }

    @NonNull
    public String getStudId() {
        return StudId;
    }

    public void setStudId(@NonNull String studId) {
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
