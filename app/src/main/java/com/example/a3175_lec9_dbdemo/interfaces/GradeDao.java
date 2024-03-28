package com.example.a3175_lec9_dbdemo.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.a3175_lec9_dbdemo.models.Grade;

import java.util.List;

@Dao
public interface GradeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOneGrade(Grade grade);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGradesFromList(List<Grade> grades);

    @Query("Select * FROM grades")
    List<Grade> GetAllGrades();

    @Query("UPDATE grades SET studgrade = studgrade * 1.1 WHERE studentid = :StudID")
    int IncreaseGradeForOneStudent(String StudID);

    @Query("UPDATE grades SET studGrade = studGrade * 1.1 WHERE studentid IN (:StudIds) AND courseid = :CourseId")
    int IncreaseGradeForStudentsInCourse(List<String> StudIds, String CourseId);
}
