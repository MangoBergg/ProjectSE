package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;


public class Activity {

    private String name;
    private Project parentProject;
    private int[] startEndWeeks = new int[2];
    private double budgetTime = 0.0;
    private List<Employee> assignedEmployeesList = new ArrayList<>();

    public Activity(String string, Project parentProject) {
        this.name = string;
        this.parentProject = parentProject;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setParentProject(Project project) {
        parentProject = project;
    }

    public Project getParentProject() {
        return parentProject;
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

    public int[] getStartEndWeeks() { 
        return startEndWeeks; 
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

    public double getBudgetedTime() {
        return budgetTime;
    }

    public void assignEmployee(Employee employee) throws Exception {
        if (containsAssignedEmployee(employee)) {
            throw new Exception("The employee is already assigned to the activity");
        }
        assignedEmployeesList.add(employee);
    }

    public boolean containsAssignedEmployee(Employee employee) {
        return assignedEmployeesList.stream().anyMatch(e -> e.getEmployeeID().equals(employee.getEmployeeID()));
    }
}