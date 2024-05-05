package dtu.example.strategies;

import java.util.Scanner;

import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;
import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IEmployee;
import dtu.example.model.Printer;

public class RegisterTimeForActivityStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            Printer.displayActivityOverview(projectManagementApp.getActivityRepository().getActivityList());
            System.out.println("What activity do you want to register time for?: ");
            IActivity activity = projectManagementApp.getActivityRepository().getActivityList().get(Integer.parseInt(inputScanner.nextLine()) - 1);
            Printer.clearScreen();
            System.out.println("How much time do you want to register?: ");
            try {
                double consumedTime = Double.parseDouble(inputScanner.nextLine());
                user.updateConsumedTime(consumedTime, activity);
            } catch (IllegalArgumentException e) {
                errorMessage.setErrorMessage("Invalid input. Consumed time must be registered in increments of 0.5: ");
            }
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
