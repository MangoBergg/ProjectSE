package system.program.strategies;

import java.util.Scanner;

import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.model.ErrorMessageHolder;
import system.program.model.Printer;
import system.program.model.ProjectManagementApp;

public class UpdateActivityBudgetedTimeStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            Printer.displayActivityOverview(projectManagementApp.getActivityRepository().getActivityList());
            System.out.println("Which activity do you want to update the budgeted time for?: ");
            IActivity activity = projectManagementApp.getActivityRepository().getActivityList().get(Integer.parseInt(inputScanner.nextLine()) - 1);
            System.out.println("Current budgeted time is: " + activity.getBudgetedTime());
            System.out.println("What should the budgeted time be?");
            try {
                double budgetedTime = Double.parseDouble(inputScanner.nextLine());
                activity.updateBudgetedTime(budgetedTime);
            } catch (IllegalArgumentException e) {
                errorMessage.setErrorMessage("Invalid input. Budgeted time must be updated in increments of 0.5: ");
            }
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
