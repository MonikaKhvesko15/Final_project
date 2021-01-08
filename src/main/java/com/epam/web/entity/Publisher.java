package com.epam.web.entity;

import java.io.Serializable;
import java.time.Year;
import java.util.Objects;

public class Publisher implements Identifiable{

    //table name for books
    public static final String TABLE = "publishers";

    //columns for table
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ESTABLISH_YEAR = "establish_year";


    private Integer id;
    private String name;
    private int establishYear;


    @Override
    public Serializable getId() {
        return id;
    }

    public Publisher(){

    }

    public Publisher(Integer id, String name, int establishYear) {
        this.id = id;
        this.name = name;
        this.establishYear = establishYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstablishyear() {
        return establishYear;
    }

    public void setEstablishYear(int establishYear) {
        this.establishYear = establishYear;
    }

}
