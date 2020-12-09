package com.example.todolistapp.Models;


public class Lists {
    private String listname ;
    private String listnum ;

    public Lists(String listname, String listnum) {
        this.listname = listname;
        this.listnum = listnum;
    }

    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    public String getListnum() {
        return listnum;
    }

    public void setListnum(String listnum) {
        this.listnum = listnum;
    }
}
