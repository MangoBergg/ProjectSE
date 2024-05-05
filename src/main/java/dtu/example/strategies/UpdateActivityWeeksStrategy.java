package dtu.example.strategies;

import java.util.Scanner;

import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;
import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IEmployee;
import dtu.example.model.Printer;

public class UpdateActivityWeeksStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            Printer.displayActivityOverview(projectManagementApp.getActivityRepository().getActivityList());
            System.out.println("What activity do you want to update the weeks?: ");
            IActivity activity = projectManagementApp.getActivityRepository().getActivityList().get(Integer.parseInt(inputScanner.nextLine()) - 1);
            System.out.println("Current start-end weeks are: " + activity.getStartEndWeeks()[0] + ", " + activity.getStartEndWeeks()[1]);
            System.out.println("What should the start week be?");
            int startWeek = Integer.parseInt(inputScanner.nextLine());
            System.out.println("What should the end week be?");
            int endWeek = Integer.parseInt(inputScanner.nextLine());
            activity.updateStartEndWeeks(startWeek, endWeek);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
