package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;

import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IEmployee;
import dtu.example.interfaces.IProject;


public class Activity implements IActivity {

    private String name;
    private IProject parentProject;
    private int[] startEndWeeks = new int[2];
    private double budgetTime = 0.0;
    private double consumedTime = 0.0;
    private List<Employee> assignedEmployeesList = new ArrayList<>();

    public Activity(String string, IProject parentProject) {
        this.name = string;
        this.parentProject = parentProject;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IProject getParentProject() {
        return parentProject;
    }

    @Override
    public int[] getStartEndWeeks() { 
        return startEndWeeks; 
    }

    @Override
    public double getBudgetedTime() {
        return budgetTime;
    }

    @Override
    public double getConsumedTime() {
        return consumedTime;
    }
    
    @Override
    public List<Employee> getAssignedEmployees() {
        return assignedEmployeesList;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void setParentProject(IProject project) {
        parentProject = project;
    }

    @Override
    public void updateStartEndWeeks(int weekStart, int weekEnd) {
        // Precondition
        assert weekEnd >= weekStart : "End week cannot be before start week";
        assert (weekStart >= 1 && weekStart <= 52 && weekEnd >= 1 && weekEnd <= 52) : "The start and end weeks must be within a year (1-52)";

        startEndWeeks[0] = weekStart;
        startEndWeeks[1] = weekEnd;
        parentProject.updateStartEndWeeks(weekStart, weekEnd);

        // Postcondition
        assert (startEndWeeks[0] == weekStart);
        assert (startEndWeeks[1] == weekEnd);
    }

    @Override
    public void updateBudgetedTime(double budgetTime) throws Exception {
        if (budgetTime <= 0.0) {
            throw new Exception("Budgeted time must be greater than 0.5 hours");
        }
        if (budgetTime % 0.5 != 0) {
            throw new Exception("Invalid input. Please ensure your number is in increments of 0.5");
        }
        this.budgetTime = budgetTime;
    }

    @Override
    public void updateConsumedTime(double double1) {
        consumedTime += double1;
    }
    
    @Override
    public void assignEmployee(Employee employee) throws Exception {
        if (containsAssignedEmployee(employee)) {
            throw new Exception("The employee is already assigned to the activity");
        }
        getAssignedEmployees().add(employee);
    }

    @Override
    public boolean containsAssignedEmployee(IEmployee employee) {
        return getAssignedEmployees().stream().anyMatch(e -> e.getEmployeeID().equals(employee.getEmployeeID()));
    }
}