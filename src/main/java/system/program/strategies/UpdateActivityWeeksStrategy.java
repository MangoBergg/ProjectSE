package system.program.strategies;

import java.util.Scanner;

import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.model.ErrorMessageHolder;
import system.program.model.Printer;
import system.program.model.ProjectManagementApp;

public class UpdateActivityWeeksStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            Printer.displayActivityOverview(projectManagementApp.getActivityRepository().getActivityList());
            System.out.println("Which activity do you want to update the weeks for?: ");
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
