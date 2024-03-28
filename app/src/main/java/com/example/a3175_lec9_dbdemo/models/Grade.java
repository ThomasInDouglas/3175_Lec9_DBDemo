package com.example.a3175_lec9_dbdemo.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName="grades", primaryKeys = {"courseid", "studentid"},
        foreignKeys = @ForeignKey(entity = Student.class, /*parent class*/
                parentColumns = "studentid", childColumns = "studentid",
                onDelete = ForeignKey.CASCADE))

public class Grade {
    @NonNull
    @ColumnInfo(name = "courseid")
    private String CourseId;

    @NonNull
    @ColumnInfo(name = "studentid")
    private String StudentId;

    @NonNull
    @ColumnInfo(name = "studGrade")
    private double StudGrade;

    public Grade() {
    }

    public Grade(@NonNull String courseId, @NonNull String studentId, double studGrade) {
        CourseId = courseId;
        StudentId = studentId;
        StudGrade = studGrade;
    }

    @NonNull
    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(@NonNull String courseId) {
        CourseId = courseId;
    }

    @NonNull
    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(@NonNull String studentId) {
        StudentId = studentId;
    }

    public double getStudGrade() {
        return StudGrade;
    }

    public void setStudGrade(double studGrade) {
        StudGrade = studGrade;
    }
}
