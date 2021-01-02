package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.todolistapp.Adapters.Note;
import com.example.todolistapp.Adapters.NoteRepository;
import com.example.todolistapp.Adapters.NoteViewModel;
import com.example.todolistapp.Adapters.TaskViewModel;
import com.example.todolistapp.Models.Lists;
import com.example.todolistapp.Models.Tasks;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class ViewTaskActivity extends AppCompatActivity {
    int meetId = 0;
    String meetName="";
    EditText note ;
    NoteViewModel mNoteViewModel ;
    private TaskViewModel mtaskViewModel;
    public static final String EXTRA_ID = "com.example.todolistapp.extraid" ;
    private com.example.todolistapp.Adapters.AddNewTaskViewModel mViewModel;
    private Object NoteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);
        meetId =  getIntent().getExtras().getInt("meetId");
        meetName =  getIntent().getExtras().getString("meetName");
        TextView textCategoryName =(TextView)findViewById(R.id.meet_name);
        textCategoryName.setText(meetName);
        mtaskViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);
        mtaskViewModel.getmAllTasks(meetId).observe(this, new Observer<List<Tasks>>() {
            @Override
            public void onChanged(List<Tasks> tasks) {
                //update ui
                //update rv
//                Toast.makeText(CategoryListActivity.this, "on changed work", Toast.LENGTH_SHORT).show();
//                adapter.setTasks(tasks);

            }
        });

        mViewModel = ViewModelProviders.of(this).get(com.example.todolistapp.Adapters.AddNewTaskViewModel.class);

        Calendar calendar = Calendar.getInstance();
        String currentdata = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView date = findViewById(R.id.date);
        date.setText(currentdata);


         note = findViewById(R.id.note);








    }

    public void backed(View view) {
        startActivity(new Intent(getApplicationContext() , MeetActivity.class));
    }

    public void update(View view) {
        String name = note.getText().toString();
        if (TextUtils.isEmpty(name)){
            note.setError("Enter List Name");

        }else {
            try {
                mNoteViewModel.update(new Note(name));

            }catch (NullPointerException r){

            }
        }



    }
}