package com.epam.web.entity;


import java.io.Serializable;

public class Order implements Identifiable{
    //table name for orders
    public static final String TABLE = "orders";


    @Override
    public Serializable getId() {
        return null;
    }
}
