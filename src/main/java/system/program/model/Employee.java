package system.program.model;

import java.util.ArrayList;
import java.util.List;

import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;

public class Employee implements IEmployee {
    private String employeeID;
    private List<ConsumedTime> consumedTimeList = new ArrayList<>();
    private List<Absence> absenceList = new ArrayList<>();

    public Employee(String string){
        this.employeeID = string;
    }

    @Override
    public String getEmployeeID() {
        return employeeID;
    }

    @Override
    public List<Absence> getAbsence() {
        return absenceList;
    }

    @Override
    public void registerAbsence(String reason, int weekStart, int weekEnd) throws Exception {
        if (weekEnd < weekStart) {
            throw new Exception("Starting week must be before the end week");
        }
        if (reason.isEmpty()) {
            throw new Exception("You must give a reason for your absence");
        }

        absenceList.add(new Absence(reason, weekStart, weekEnd));
    }

    @Override
    public List<ConsumedTime> getConsumedTimes() {
        return consumedTimeList;
    }
    
    @Override
    public void changeConsumedTime(double hours, IActivity activity) throws Exception {
        assert hours >= 0.5 : "Consumed time must be greater than or equal to 0.5 hours";
        assert hours % 0.5 == 0 : "Invalid input. Please ensure your time is in increments of 0.5";

        for (ConsumedTime consumedTime : consumedTimeList) {
            if (consumedTime.activity.getName().equals(activity.getName())) {
                double toChangeInActivity = hours - consumedTime.time;
                consumedTime.time = hours;
                activity.updateConsumedTime(toChangeInActivity);
                return;
            }
        }
    }

    @Override
    public void updateConsumedTime(double hours, IActivity activity) {
        //Pre-conditions
        assert hours >= 0.5 : "Consumed time must be greater than or equal to 0.5 hours";
        assert hours % 0.5 == 0 : "Invalid input. Please ensure your time is in increments of 0.5";

        for (ConsumedTime consumedTime : consumedTimeList) {
            if (consumedTime.activity.getName().equals(activity.getName())) {
                consumedTime.time += hours;
                activity.updateConsumedTime(hours);
                return;
            }
        }
        ConsumedTime consumedTime = new ConsumedTime(hours, activity);
        consumedTimeList.add(consumedTime);
        //Post-conditions
        assert consumedTimeList.contains(consumedTime) : "Consumed time has not been updated";
        activity.updateConsumedTime(hours);
    }
}
