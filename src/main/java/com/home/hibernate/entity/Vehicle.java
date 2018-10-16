package com.home.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Vehicle {
    @Id
    @Column(name = "ID")
    private int ID;
    @Column(name = "Year")
    private int year;
    @Column(name = "Make")
    private String make;
    @Column(name = "Model")
    private String model;

    public Vehicle(int id, int year, String make, String model) {
        this.ID = id;
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString()
    {
        return getID() + " " + getModel() + " " + getMake() + " " + getYear();
    }
}
