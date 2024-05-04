package dtu.example.repositories;

import java.util.ArrayList;
import java.util.List;

import dtu.example.interfaces.IEmployee;


public class EmployeeRepository {
    private static EmployeeRepository instance;

    private List<IEmployee> employeeList = new ArrayList<>();

    private EmployeeRepository(){}
    
    public static EmployeeRepository getInstance() {
        if (instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;
    }

    public List<IEmployee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(IEmployee employee) {
        employeeList.add(employee);
    }

    public boolean containsProject(String employeeName) {
        return employeeList.stream().anyMatch(p -> p.getEmployeeID().equals(employeeName));
    }

    public IEmployee getEmployeeFromName(String employeeToFind) throws Exception {
        for (IEmployee employee : employeeList) {
            if (employee.getEmployeeID().equals(employeeToFind)) {
                return employee;
            }
        }

        throw new Exception("That employee doesn't exist in the system");
    }

    public void reset() { //Only for testing purposes and should only be called in tests.
        instance = new EmployeeRepository();
    }
}
