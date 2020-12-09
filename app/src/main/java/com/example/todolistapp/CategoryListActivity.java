package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.todolistapp.Adapters.ListsAdapter;
import com.example.todolistapp.Adapters.OnItemCilckListener;
import com.example.todolistapp.Adapters.OnTaskClickListener;
import com.example.todolistapp.Adapters.TaskAdapter;
import com.example.todolistapp.Models.Lists;
import com.example.todolistapp.Models.Tasks;

import java.util.ArrayList;

public class CategoryListActivity extends AppCompatActivity {

    RecyclerView rv ;
    ArrayList<Tasks> tasks = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        rv= findViewById(R.id.task_rv);

        tasksData();

       TaskAdapter adapter = new TaskAdapter(tasks, new OnTaskClickListener() {
           @Override
           public void onClickLisener(Tasks tasks) {
               Toast.makeText(CategoryListActivity.this, "clicked", Toast.LENGTH_SHORT).show();

           }
       }, rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);

    }

    private void tasksData() {
        tasks.add(new Tasks("Meeting with client" , R.drawable.task_unclicked));
        tasks.add(new Tasks("Lunch with julie" , R.drawable.task_unclicked));
        tasks.add(new Tasks("Meeting with client" ,R.drawable.task_clicked));
    }
}