package dtu.example.model;

import dtu.example.interfaces.IDeveloper;

public class Developer extends Employee implements IDeveloper {

    public Developer(String string) {
        super(string);
    } 
}
