package com.example.todolistapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistapp.Models.Lists;
import com.example.todolistapp.R;

import java.util.ArrayList;

public class ListsAdapter extends RecyclerView.Adapter<ListsAdapter.ListViewHolder> {

    ArrayList<Lists> lists = new ArrayList<>();
    OnItemCilckListener listener ;
    RecyclerView mRecyclrerView;
    Context context;

    public ListsAdapter(ArrayList<Lists> lists, OnItemCilckListener listener, RecyclerView mRecyclrerView) {
        this.lists = lists;
        this.listener = listener;
        this.mRecyclrerView = mRecyclrerView;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new ListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listrow, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        holder.list_name.setText(lists.get(position).getListname());
        holder.list_num.setText(lists.get(position).getListnum());

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView list_name , list_num ;



        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            list_name = itemView.findViewById(R.id.list_name);
            list_num = itemView.findViewById(R.id.list_num);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int pos = mRecyclrerView.getChildAdapterPosition(v);
                    listener.onItemClick(lists.get(pos));


                }
            });
        }
    }
}
