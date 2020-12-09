package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.todolistapp.Adapters.ListsAdapter;
import com.example.todolistapp.Adapters.OnItemCilckListener;
import com.example.todolistapp.Models.Lists;

import java.util.ArrayList;

public class ListsActivity extends AppCompatActivity {

    RecyclerView rv ;
    ArrayList<Lists> lists = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        rv=findViewById(R.id.list_rv);
        listsData();

        ListsAdapter adapter = new ListsAdapter(lists, new OnItemCilckListener() {
            @Override
            public void onItemClick(Lists lists) {
                Toast.makeText(ListsActivity.this, "clicked ", Toast.LENGTH_SHORT).show();

            }
        }, rv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);




    }

    private void listsData() {
        lists.add(new Lists("Home" , "3tasks"));
        lists.add(new Lists("Personal" , "3tasks"));
        lists.add(new Lists("Work" , "3tasks"));
        lists.add(new Lists("University" , "3tasks"));





    }


}