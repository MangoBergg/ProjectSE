package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String employeeID;
    private List<ConsumedTime> consumedTimeList = new ArrayList<>();
    private List<Absence> absenceList = new ArrayList<>();

    public Employee(String string){
        this.employeeID = string;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public List<Absence> getAbsence() {
        return absenceList;
    }

    public void updateConsumedTime(double hours, Activity activity) throws Exception {
        if (hours < 0.5) {
            throw new Exception("Consumed time must be greater than or equal to 0.5 hours");
        }
        
        if (hours % 0.5 != 0) {
            throw new Exception("Invalid input. Please ensure your time is in increments of 0.5");
        }

        for (ConsumedTime consumedTime : consumedTimeList) {
            if (consumedTime.activity.getName().equals(activity.getName())) {
                consumedTime.time += hours;
                activity.updateConsumedTime(hours);
                return;
            }
        }
        consumedTimeList.add(new ConsumedTime(hours, activity));
        activity.updateConsumedTime(hours);
    }

    public void registerAbsence(String reason, int weekStart, int weekEnd) throws Exception {
        if (weekEnd < weekStart) {
            throw new Exception("Starting week must be before the end week");
        }
        if (reason.isEmpty()) {
            throw new Exception("You must give a reason for your absence");
        }

        absenceList.add(new Absence(reason, weekStart, weekEnd));
    }
}
