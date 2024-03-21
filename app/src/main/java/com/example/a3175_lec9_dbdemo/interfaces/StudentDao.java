package com.example.a3175_lec9_dbdemo.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.a3175_lec9_dbdemo.models.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) //Ignore or Replace when the record already exist
    void insertStudents(Student... students); //... array of students

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long[] insertStudentsFromList(List<Student> studentList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOneStudent(Student student);

    @Query("SELECT * from students")
    List<Student> GetAllStudents();
}
