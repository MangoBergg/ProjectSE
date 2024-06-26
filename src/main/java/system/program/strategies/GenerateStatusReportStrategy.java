package system.program.strategies;

import java.util.Scanner;

import system.program.interfaces.IEmployee;
import system.program.interfaces.IProject;
import system.program.model.ErrorMessageHolder;
import system.program.model.Printer;
import system.program.model.ProjectManagementApp;

public class GenerateStatusReportStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            System.out.println("Which project do you want to generate a status report for?: ");
            IProject project = projectManagementApp.getProjectRepository().getProjectList().get(Integer.parseInt(inputScanner.nextLine()) - 1);
            Printer.clearScreen();
            System.out.println(project.makeReport());
            System.out.println("Type anything to go back: ");
            inputScanner.nextLine();
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
