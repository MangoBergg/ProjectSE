package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String employeeID;
    private List<ConsumedTime> consumedTimes = new ArrayList<>();

    public Employee(String string){
        this.employeeID = string;
    }

    public String getEmployeeID() {
        return employeeID;
    }
}
