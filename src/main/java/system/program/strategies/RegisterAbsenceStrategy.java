package system.program.strategies;

import java.util.Scanner;

import system.program.interfaces.IEmployee;
import system.program.model.ErrorMessageHolder;
import system.program.model.Printer;
import system.program.model.ProjectManagementApp;

public class RegisterAbsenceStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            System.out.println("What is the reason for your absence?: ");
            String reason = inputScanner.nextLine();
            System.out.println("What is the starting week of your absence?: ");
            int startWeek = Integer.parseInt(inputScanner.nextLine());
            System.out.println("What is the end week of your absence?: ");
            int endWeek = Integer.parseInt(inputScanner.nextLine());
            user.registerAbsence(reason, startWeek, endWeek);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
