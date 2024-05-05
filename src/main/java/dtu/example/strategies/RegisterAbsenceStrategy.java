package dtu.example.strategies;

import java.util.Scanner;

import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.ProjectManagementApp;
import dtu.example.interfaces.IEmployee;
import dtu.example.model.Printer;

public class RegisterAbsenceStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            Printer.clearScreen();
            System.out.println("What's the reason for your absence?: ");
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
