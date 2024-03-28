package com.example.a3175_lec9_dbdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.a3175_lec9_dbdemo.R;
import com.example.a3175_lec9_dbdemo.databases.CollegeDatabase;
import com.example.a3175_lec9_dbdemo.databinding.ActivityNextBinding;
import com.example.a3175_lec9_dbdemo.models.Grade;
import com.example.a3175_lec9_dbdemo.models.Student;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NextActivity extends AppCompatActivity {

    CollegeDatabase cdb;
    ActivityNextBinding binding;

    StringBuilder outputText = new StringBuilder(); //string builder must be non null for append to work

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        binding = ActivityNextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cdb = Room.databaseBuilder(getApplicationContext(), CollegeDatabase.class, "college.db").build();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                int retValue = cdb.studentDao().deleteOneStudentWithId("312345");
                Log.d("DBDEMO", "Deleted records from students = " + retValue);

                List<Student> StudentList = cdb.studentDao().GetAllStudents();
                outputText.append("Displaying students after delete...\n\n");
                outputText.append(String.format("%-10s%-10s%-10s\n", "StudId", "StudName", "Dept"));// (%-10 --> justify "-", 10 charters length)
                for (Student student:StudentList){
                    outputText.append(String.format("%-10s%-10s%-10s\n", student.getStudId(), student.getStudName(), student.getStuDept()));
                }
                outputText.append("\n\n\nIncrease grade for one student\n\n");
                int retUpdate = cdb.gradeDao().IncreaseGradeForOneStudent("123567");

                List<String> StudIds = Arrays.asList("300234", "123567");
                String CourseId = "CSIS3475";

                int retUpdate2 = cdb.gradeDao().IncreaseGradeForStudentsInCourse(StudIds,CourseId);
                Log.d("DBDEMO", "Updated number of records = " + retUpdate2);

                outputText.append(String.format("%-10s%-10s%-10s\n", "CourseId", "StudentId", "StudGrade"));
                List<Grade> GradeList = cdb.gradeDao().GetAllGrades();
                for (Grade grade:GradeList){
                    outputText.append(String.format("%-10s%-10s%-10.2f\n" /* f- for double*/, grade.getCourseId(), grade.getStudentId(), grade.getStudGrade()));
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        binding.txtViewSummary.setText(outputText);
                    }
                });
            }
        });
    }
}