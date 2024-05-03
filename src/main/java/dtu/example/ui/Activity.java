package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;


public class Activity {

    private String name;
    private Project parentProject;
    private int[] startEndWeeks = new int[2];
    private double budgetTime = 0.0;
    private double consumedTime = 0.0;
    private List<Employee> assignedEmployeesList = new ArrayList<>();

    public Activity(String string, Project parentProject) {
        this.name = string;
        this.parentProject = parentProject;
        startEndWeeks[0] = 0;
        startEndWeeks[1] = 0;
    }

    public String getName() {
        return name;
    }

    public Project getParentProject() {
        return parentProject;
    }

    public int[] getStartEndWeeks() { 
        return startEndWeeks; 
    }

    public double getBudgetedTime() {
        return budgetTime;
    }

    public double getConsumedTime() {
        return consumedTime;
    }
    
    public List<Employee> getAssignedEmployees() {
        return assignedEmployeesList;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setParentProject(Project project) {
        parentProject = project;
    }

    public void updateStartEndWeeks(int weekStart, int weekEnd) throws Exception {
        if (weekEnd < weekStart) {
            throw new Exception("End week cannot be before start week");
        }
        if (weekStart < 1 || weekStart > 52 || weekEnd > 52) {
            throw new Exception("The start and end weeks must be within a year (1-52)");
        }
        else {
            startEndWeeks[0] = weekStart;
            startEndWeeks[1] = weekEnd;
            parentProject.updateStartEndWeeks(weekStart, weekEnd);
        }
    }

    public void updateBudgetedTime(double budgetTime) throws Exception {
        if (budgetTime <= 0.0) {
            throw new Exception("Budgeted time must be greater than 0.5 hours");
        }
        if (budgetTime % 0.5 != 0) {
            throw new Exception("Invalid input. Please ensure your number is in increments of 0.5");
        }
        this.budgetTime = budgetTime;
    }

    public void updateConsumedTime(double double1) {
        consumedTime += double1;
    }
    
    public void assignEmployee(Employee employee) throws Exception {
        if (containsAssignedEmployee(employee)) {
            throw new Exception("The employee is already assigned to the activity");
        }
        getAssignedEmployees().add(employee);
    }

    public boolean containsAssignedEmployee(Employee employee) {
        return getAssignedEmployees().stream().anyMatch(e -> e.getEmployeeID().equals(employee.getEmployeeID()));
    }
}