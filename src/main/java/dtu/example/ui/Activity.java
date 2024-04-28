package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class Activity {

    private String name;
    private int[] startEndWeeks = new int[2];
    private double budgetTime = 0.0;
    public Project parentProject;
    private List<Employee> employeeList = new ArrayList<>();


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


    public double getBudgetTime() {
        return budgetTime;
    }


    public Employee assignEmployee(String string) throws Exception {
        if (containsEmployee(string)) {
            throw new Exception("The employee is already assigned to the activity ’Activity’");
        }
        Employee employee = new Employee(string);
        addEmployee(employee);
        return employee;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public boolean containsEmployee(String employeeID) {
        return employeeList.stream().anyMatch(e -> e.getEmployeeID().equals(employeeID));
    }

}