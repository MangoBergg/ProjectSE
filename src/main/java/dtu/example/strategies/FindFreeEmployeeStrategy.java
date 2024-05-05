package dtu.example.strategies;

import java.util.Scanner;

import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;
import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IEmployee;
import dtu.example.model.Printer;

public class FindFreeEmployeeStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            Printer.displayActivityOverview(projectManagementApp.getActivityRepository().getActivityList());
            System.out.println("What activity do you want to find an employee for?: ");
            IActivity activity = projectManagementApp.getActivityRepository().getActivityList().get(Integer.parseInt(inputScanner.nextLine()) - 1);
            Printer.clearScreen();
            Printer.displayEmployeeOverview(projectManagementApp.findFreeEmployees(activity));
            System.out.println("Write any number to go back:");
            inputScanner.nextLine();
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
