package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;


public class Activity {

    private String name;
    private int[] startEndWeeks = new int[2];
    private double budgetTime = 0.0;
    private double consumedTime = 0.0;
    private double totalConsumedTime;
    public Project parentProject;
    public List<Employee> assignedEmployeesList = new ArrayList<>();


    public Activity(String string, Project parentProject) {
        this.name = string;
        this.parentProject = parentProject;
    }

    public String getName() {
        return name;
    }

    public void updateStartEndWeeks(int weekStart, int weekEnd) throws Exception {
        if (weekEnd < weekStart) {
            throw new Exception("End week cannot be before start week");
        } else {
            startEndWeeks[0] = weekStart;
            startEndWeeks[1] = weekEnd;
            parentProject.updateStartEndWeeks(weekStart, weekEnd);
        }
    }

    public int[] getStartEndWeeks() { return startEndWeeks; }


    public void updateBudgetedTime(double budgetTime) throws Exception {
        if (budgetTime <= 0.0) {
            throw new Exception("Budgeted time must be greater than 0.5 hours");
        }
        if (budgetTime % 0.5 != 0) {
            throw new Exception("Invalid input. Please ensure your number is in increments of 0.5");
        }
        this.budgetTime = budgetTime;
    }

    public double getBudgetTime() {
        return budgetTime;
    }

    public void assignEmployee(Employee employee) throws Exception {
        if (containsAssignedEmployee(employee.getEmployeeID())) {
            throw new Exception("The employee is already assigned to the activity ’Activity’");
        }
        addAssignedEmployee(employee);
    }

    public void addAssignedEmployee(Employee employee) {
        assignedEmployeesList.add(employee);
    }

    public boolean containsAssignedEmployee(String employeeID) {
        return assignedEmployeesList.stream().anyMatch(e -> e.getEmployeeID().equals(employeeID));
    }
}