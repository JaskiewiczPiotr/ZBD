package com.example.demo;

public class aeh_students {

    private String name;
    private String lastname;

    public aeh_students(String name, String lastname){
        this.name = name;
        this.lastname = lastname;

    }
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
