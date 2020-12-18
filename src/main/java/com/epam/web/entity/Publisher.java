package com.epam.web.entity;

import java.io.Serializable;
import java.time.Year;

public class Publisher implements Identifiable{

    //table name for books
    public static final String TABLE = "publishers";

    //columns for table
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String YEAR = "year";


    private int id;
    private String name;
    private Year year;


    @Override
    public Serializable getId() {
        return id;
    }

    public Publisher(){

    }

    public Publisher(int id, String name, Year year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
}
