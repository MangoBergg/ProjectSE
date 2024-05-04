package dtu.example.interfaces;

import java.util.List;

import dtu.example.ui.Employee;

public interface IActivity {

    String getName();

    IProject getParentProject();

    int[] getStartEndWeeks();

    double getBudgetedTime();

    double getConsumedTime();

    List<Employee> getAssignedEmployees();

    void setName(String name);

    void setParentProject(IProject project);

    void updateStartEndWeeks(int weekStart, int weekEnd);

    void updateBudgetedTime(double budgetTime) throws Exception;

    void updateConsumedTime(double double1);

    void assignEmployee(Employee employee) throws Exception;

    boolean containsAssignedEmployee(IEmployee employee);

}