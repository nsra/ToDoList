package com.example.todolistapp.Models;


public class Tasks {
    private String tastName ;
    private int select ;

    public Tasks(String tastName, int select) {
        this.tastName = tastName;
        this.select = select;
    }

    public String getTastName() {
        return tastName;
    }

    public void setTastName(String tastName) {
        this.tastName = tastName;
    }

    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }
}
