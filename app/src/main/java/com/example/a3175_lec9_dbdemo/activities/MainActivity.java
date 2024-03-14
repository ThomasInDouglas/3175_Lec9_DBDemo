package com.example.a3175_lec9_dbdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a3175_lec9_dbdemo.R;
import com.example.a3175_lec9_dbdemo.databinding.ActivityMainBinding;
import com.example.a3175_lec9_dbdemo.models.Student;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Student> Students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //set up adapter for listview
        //set adapter on listview
    }

    private void ReadCSV(){
        Students = new ArrayList<>();
        InputStream inputStream = getResources().openRawResource(R.raw.students);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        //rest of the file read logic next class
    }

}