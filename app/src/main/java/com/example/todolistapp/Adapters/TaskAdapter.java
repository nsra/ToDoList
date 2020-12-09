package com.example.todolistapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistapp.Models.Tasks;
import com.example.todolistapp.R;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    ArrayList<Tasks> tasks = new ArrayList<>();
    OnTaskClickListener listener ;
    Context context ;
    RecyclerView mRecyclrerView ;

    public TaskAdapter(ArrayList<Tasks> tasks, OnTaskClickListener listener, RecyclerView mRecyclerView) {
        this.tasks = tasks;
        this.listener = listener;
        this.mRecyclrerView = mRecyclerView;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new TaskViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.taskrow, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.taskname.setText(tasks.get(position).getTastName());
        holder.select.setImageResource(tasks.get(position).getSelect());


    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView taskname ;
        ImageView select ;

        public TaskViewHolder(@NonNull View itemView) {

            super(itemView);
            taskname=itemView.findViewById(R.id.tast_name);
            select = itemView.findViewById(R.id.select);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = mRecyclrerView.getChildAdapterPosition(view);
                    listener.onClickLisener(tasks.get(pos));

                }
            });

        }
    }
}
