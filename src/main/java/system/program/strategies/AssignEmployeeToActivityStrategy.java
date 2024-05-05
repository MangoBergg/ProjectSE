package system.program.strategies;

import java.util.List;
import java.util.Scanner;

import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.model.ErrorMessageHolder;
import system.program.model.Printer;
import system.program.model.ProjectManagementApp;

public class AssignEmployeeToActivityStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            Printer.displayActivityOverview(projectManagementApp.getActivityRepository().getActivityList());
            System.out.println("Which activity do you want to assign an employee to?: ");
            IActivity activity = projectManagementApp.getActivityRepository().getActivityList().get(Integer.parseInt(inputScanner.nextLine()) - 1);
            Printer.clearScreen();
            List<IEmployee> freeEmployeeList = projectManagementApp.findFreeEmployees(activity);
            Printer.displayEmployeeOverview(freeEmployeeList);
            System.out.println("Which free employee should be assigned?");
            IEmployee employee = freeEmployeeList.get(Integer.parseInt(inputScanner.nextLine()) - 1);
            activity.assignEmployee(employee);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
