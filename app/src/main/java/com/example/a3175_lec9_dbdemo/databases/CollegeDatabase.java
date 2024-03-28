package com.example.a3175_lec9_dbdemo.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.a3175_lec9_dbdemo.interfaces.GradeDao;
import com.example.a3175_lec9_dbdemo.interfaces.StudentDao;
import com.example.a3175_lec9_dbdemo.models.Grade;
import com.example.a3175_lec9_dbdemo.models.Student;

@Database(entities = {Student.class, Grade.class}, version = 1, exportSchema = false)
public abstract class CollegeDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();

    public abstract GradeDao gradeDao();
}
