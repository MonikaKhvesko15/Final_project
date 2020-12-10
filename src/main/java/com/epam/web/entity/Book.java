package com.epam.web.entity;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

public class Book implements Identifiable {

    //table name for books
    public static final String TABLE = "books";

    //columns for table
    public static final String TITLE = "title";
    public static final String AUTHOR = "author";
    public static final String NUMB_OF_PAGES = "numb_of_pages";
    public static final String YEAR_OF_PUBLISHING = "year_of_publishing";
    public static final String AMOUNT = "amount";


    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void write(OutputStream arg0) {

    }
}
