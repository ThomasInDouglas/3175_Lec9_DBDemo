package com.example.a3175_lec9_dbdemo.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import com.example.a3175_lec9_dbdemo.databinding.LayoutStudentitemBinding;
import com.example.a3175_lec9_dbdemo.models.Student;

public class StudentAdapter extends BaseAdapter {
    List<Student> adapterStudents;
    LayoutStudentitemBinding itemBinding;

    public StudentAdapter(List<Student> adapterStudents) {
        this.adapterStudents = adapterStudents;
    }

    @Override
    public int getCount() {
        return adapterStudents.size() + 1; // 1 more than data to accommodate for header
    }

    @Override
    public Object getItem(int i) {
        return adapterStudents.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            itemBinding = LayoutStudentitemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false); // take 3 arguments: (layout inflater, parent, not attach to parent )
        }
        if (i == 0) {
            itemBinding.txtViewDept.setText("StudDept");
            itemBinding.txtViewStudId.setText("StudId");
            itemBinding.txtViewStudName.setText("StudName");

            itemBinding.txtViewDept.setTextColor(Color.RED);
            itemBinding.txtViewStudId.setTextColor(Color.RED);
            itemBinding.txtViewStudName.setTextColor(Color.RED);
        } else {
            // remember to convert the numeric data or date data into string
            itemBinding.txtViewDept.setText(adapterStudents.get(i-1).getStuDept());
            itemBinding.txtViewStudId.setText(adapterStudents.get(i-1).getStudId());
            itemBinding.txtViewStudName.setText(adapterStudents.get(i-1).getStudName());

            itemBinding.txtViewDept.setTextColor(Color.BLACK);
            itemBinding.txtViewStudId.setTextColor(Color.BLACK);
            itemBinding.txtViewStudName.setTextColor(Color.BLACK);
        }
        return itemBinding.getRoot();
    }
}
