package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String employeeID;
    private List<ConsumedTime> consumedTimeList;

    public Employee(String string){
        this.employeeID = string;
        consumedTimeList = new ArrayList<>();
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void updateConsumedTime(Double double1, Activity testActivity) throws Exception {
        if (double1 <= 0.0) {
            throw new Exception("Consumed time must be greater than 0.5 hours");
        }
        
        if (double1 % 0.5 != 0) {
            throw new Exception("Invalid input. Please ensure your time is in increments of 0.5");
        }

        for (ConsumedTime consumedTime : consumedTimeList) {
            if (consumedTime.activity.getName().equals(testActivity.getName())) {
                consumedTime.time += double1;
                testActivity.updateConsumedTime(double1);
                return;
            }
        }
        consumedTimeList.add(new ConsumedTime(double1, testActivity));
        testActivity.updateConsumedTime(double1);
    }

    
}
