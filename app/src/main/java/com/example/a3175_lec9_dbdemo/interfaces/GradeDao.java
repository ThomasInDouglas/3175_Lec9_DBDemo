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

    @Query("Select * from grades")
    List<Grade> GetAllGrades();
}
