package system.program.strategies;

import java.util.Scanner;

import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.model.ErrorMessageHolder;
import system.program.model.Printer;
import system.program.model.ProjectManagementApp;

public class FindFreeEmployeeStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            Printer.displayActivityOverview(projectManagementApp.getActivityRepository().getActivityList());
            System.out.println("Which activity do you want to find an employee for?: ");
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
