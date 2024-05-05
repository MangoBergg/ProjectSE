package dtu.example.strategies;

import java.util.Scanner;

import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;
import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IEmployee;
import dtu.example.model.Printer;

public class AssignEmployeeToActivityStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            Printer.displayActivityOverview(projectManagementApp.getActivityRepository().getActivityList());
            System.out.println("What activity do you want to assign an employee to?: ");
            IActivity activity = projectManagementApp.getActivityRepository().getActivityList().get(Integer.parseInt(inputScanner.nextLine()) - 1);
            Printer.clearScreen();
            Printer.displayEmployeeOverview(projectManagementApp.getEmployeeRepository().getEmployeeList());
            System.out.println("What employee should be added?");
            IEmployee employee = projectManagementApp.getEmployeeRepository().getEmployeeList().get(Integer.parseInt(inputScanner.nextLine()) - 1);
            activity.assignEmployee(employee);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
