package system.program.strategies;

import java.util.Scanner;

import system.program.interfaces.IEmployee;
import system.program.model.ErrorMessageHolder;
import system.program.model.ProjectManagementApp;

public class CreateProjectStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            System.out.println("Give a title for the project: ");
            projectManagementApp.getProjectFactory().createProject(inputScanner.nextLine());
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
