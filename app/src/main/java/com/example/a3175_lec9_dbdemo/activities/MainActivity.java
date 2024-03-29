package com.example.a3175_lec9_dbdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.a3175_lec9_dbdemo.R;
import com.example.a3175_lec9_dbdemo.adapters.StudentAdapter;
import com.example.a3175_lec9_dbdemo.databases.CollegeDatabase;
import com.example.a3175_lec9_dbdemo.databinding.ActivityMainBinding;
import com.example.a3175_lec9_dbdemo.models.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    List<Student> Students = new ArrayList<>();

    CollegeDatabase cdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ReadCSV();
        Log.d("DBDEMO",Students.size() + " Items");
        //set up adapter for listview
        StudentAdapter studentAdapter = new StudentAdapter(Students);

        //set adapter on listview
        //binding.listViewStudents.setAdapter(studentAdapter);

        // database builder (the context, database class, name)
        cdb = Room.databaseBuilder(getApplicationContext(), CollegeDatabase.class, "college.db").build();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                cdb.StudentDao().insertStudentsFromList(Students);
                List<Student> StudentDB = cdb.StudentDao().GetAllStudents();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        binding.listViewStudents.setAdapter(new StudentAdapter(StudentDB));
                    }
                });
            }
        });
    }

    private void ReadCSV(){
        Students = new ArrayList<>();
        //reads students from students.csv
        InputStream inputStream = getResources().openRawResource(R.raw.students);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        //rest of the file read logic next class
        String studentLine;
        try{
            if ((studentLine = reader.readLine()) != null){
                //header line is contained in studentLine
            }
            while((studentLine = reader.readLine()) != null){
                String[] eachStudFields = studentLine.split(",");
                Student eachStudent = new Student(eachStudFields[0], eachStudFields[1], eachStudFields[2]);
                Students.add(eachStudent);
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            try{
                inputStream.close();
            } catch (IOException ex) {

            }
        }

    }

}