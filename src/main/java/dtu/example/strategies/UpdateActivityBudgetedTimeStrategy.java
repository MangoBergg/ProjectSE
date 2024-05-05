package dtu.example.strategies;

import java.util.Scanner;

import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;
import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IEmployee;
import dtu.example.model.Printer;

public class UpdateActivityBudgetedTimeStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            Printer.displayActivityOverview(projectManagementApp.getActivityRepository().getActivityList());
            System.out.println("What activity do you want to update the budgeted time?: ");
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
