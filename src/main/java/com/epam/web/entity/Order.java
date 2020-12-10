package com.epam.web.entity;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

public class Order implements Identifiable {
    //table name for orders
    public static final String TABLE = "orders";



    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void write(OutputStream arg0) {

    }
}
