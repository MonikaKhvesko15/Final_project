package com.epam.web.entity;

import java.io.Serializable;
import java.time.Year;
import java.util.Objects;

/**
 * The {@code Publisher} class represents Publisher.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public class Publisher implements Identifiable {

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

    public Publisher() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return establishYear == publisher.establishYear &&
                Objects.equals(id, publisher.id) &&
                Objects.equals(name, publisher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, establishYear);
    }
}
