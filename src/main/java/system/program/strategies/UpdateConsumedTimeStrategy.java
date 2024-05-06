package system.program.strategies;

import java.util.Scanner;

import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.model.ErrorMessageHolder;
import system.program.model.Printer;
import system.program.model.ProjectManagementApp;

public class UpdateConsumedTimeStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            System.out.println("Which activity do you want to change the consumed time for?: ");
            if (user.getConsumedTimes().isEmpty()) {
                throw new Exception("You don't have any consumed time registered");
            } else {
                Printer.displayConsumedTime(user.getConsumedTimes());
                IActivity activity = user.getConsumedTimes().get(Integer.parseInt(inputScanner.nextLine()) - 1).activity;
                System.out.println("What do you want to change the time to?");
                double hours = Double.parseDouble(inputScanner.nextLine());
                user.changeConsumedTime(hours, activity);
            }
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
