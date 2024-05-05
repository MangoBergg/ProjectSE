package system.program.model;

import system.program.interfaces.IDeveloper;

public class Developer extends Employee implements IDeveloper {

    public Developer(String string) {
        super(string);
    } 
}
